﻿using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Hl7.Fhir.Model;
using Hl7.Fhir.Parsers;
using System.Xml;
using System.Xml.Linq;
using System.IO;
using Hl7.Fhir.Support;
using Newtonsoft.Json;


namespace Hl7.Fhir.Tests
{
    [TestClass]
    public class CompositeParserTests
    {
        [TestMethod]
        public void NarrativeParsing()
        {
            string xmlString = @"<testNarrative xmlns='http://hl7.org/fhir'>
                                    <status value='generated' />
                                    <div xmlns='http://www.w3.org/1999/xhtml'>Whatever</div>
                                 </testNarrative>";

            ErrorList errors = new ErrorList();
            Narrative result = (Narrative)FhirParser.ParseElementFromXml(xmlString, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Value);
            Assert.IsTrue(result.Div != null);

            xmlString = @"<testNarrative xmlns='http://hl7.org/fhir'>
                             <status value='generated' />
                             <xhtml:div xmlns:xhtml='http://www.w3.org/1999/xhtml'>Whatever</xhtml:div>
                          </testNarrative>";
            errors.Clear();

            result = (Narrative)FhirParser.ParseElementFromXml(xmlString, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Value);
            Assert.IsTrue(result.Div != null);

            xmlString = @"<testNarrative xmlns='http://hl7.org/fhir' xmlns:xhtml='http://www.w3.org/1999/xhtml'>
                              <status value='generated' />
                              <xhtml:div>Whatever</xhtml:div>
                          </testNarrative>";
            errors.Clear();

            result = (Narrative)FhirParser.ParseElementFromXml(xmlString, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Value);
            Assert.IsTrue(result.Div != null);

            string jsonString = "{ \"testNarrative\" : {" +
                "\"status\" : { \"value\" : \"generated\" }, " +
                "\"div\" : " +
                "\"<div xmlns='http://www.w3.org/1999/xhtml'>Whatever</div>\" } }";

            errors.Clear();
            result = (Narrative)FhirParser.ParseElementFromJson(jsonString, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Value);
            Assert.IsTrue(result.Div != null);
        }


        [TestMethod]
        public void BinaryParsing()
        {
            string xmlString = @"<Binary id='pic1' contentType='image/gif' xmlns='http://hl7.org/fhir'>R0lGODlhEwARAPcAAAAAAAAA/+9aAO+1AP/WAP/eAP/eCP/eEP/eGP/nAP/nCP/nEP/nIf/nKf/nUv/nWv/vAP/vCP/vEP/vGP/vIf/vKf/vMf/vOf/vWv/vY//va//vjP/3c//3lP/3nP//tf//vf///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////yH5BAEAAAEALAAAAAATABEAAAi+AAMIDDCgYMGBCBMSvMCQ4QCFCQcwDBGCA4cLDyEGECDxAoAQHjxwyKhQAMeGIUOSJJjRpIAGDS5wCDly4AALFlYOgHlBwwOSNydM0AmzwYGjBi8IHWoTgQYORg8QIGDAwAKhESI8HIDgwQaRDI1WXXAhK9MBBzZ8/XDxQoUFZC9IiCBh6wEHGz6IbNuwQoSpWxEgyLCXL8O/gAnylNlW6AUEBRIL7Og3KwQIiCXb9HsZQoIEUzUjNEiaNMKAAAA7</Binary>";

            ErrorList errors = new ErrorList();
            Binary result = (Binary)FhirParser.ParseResourceFromXml(xmlString, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());

            Assert.AreEqual("image/gif", result.ContentType);
            Assert.AreEqual(993, result.Content.Length);
            Assert.IsTrue(Encoding.ASCII.GetString(result.Content).StartsWith("GIF89a"));

            byte[] data = result.Content;
            File.WriteAllBytes(@"c:\temp\test.gif", data);

            string json = "{ Binary: { contentType : \"image/gif\", " +
                        "content: \"R0lGODlhEwARAPcAAAAAAAAA/+9aAO+1AP/WAP/eAP/eCP/eEP/eGP/nAP/nCP/nEP/nIf/nKf/nUv/nWv/vAP/vCP/vEP/vGP/vIf/vKf/vMf/vOf/vWv/vY//va//vjP/3c//3lP/3nP//tf//vf///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////yH5BAEAAAEALAAAAAATABEAAAi+AAMIDDCgYMGBCBMSvMCQ4QCFCQcwDBGCA4cLDyEGECDxAoAQHjxwyKhQAMeGIUOSJJjRpIAGDS5wCDly4AALFlYOgHlBwwOSNydM0AmzwYGjBi8IHWoTgQYORg8QIGDAwAKhESI8HIDgwQaRDI1WXXAhK9MBBzZ8/XDxQoUFZC9IiCBh6wEHGz6IbNuwQoSpWxEgyLCXL8O/gAnylNlW6AUEBRIL7Og3KwQIiCXb9HsZQoIEUzUjNEiaNMKAAAA7\" } }";
            errors.Clear();
            result = (Binary)FhirParser.ParseResourceFromJson(json, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());

            Assert.AreEqual("image/gif", result.ContentType);
            Assert.AreEqual(993, result.Content.Length);
            Assert.IsTrue(Encoding.ASCII.GetString(result.Content).StartsWith("GIF89a"));
        }

        [TestMethod]
        public void ParseJsonNativeTypes()
        {
            string json = "{ testExtension: { url: { value : \"http://bla.com\" }," +  
                        "isModifier: { value: true }, valueInteger: { value: 14 } } }";

            var errors = new ErrorList();
            var result = (Extension)FhirParser.ParseElementFromJson(json, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsTrue(result.IsModifier.Value);
            Assert.AreEqual(14, ((Integer)result.Value).Value.Value);

            string jsonWrong = "{ testExtension: { url: { value : \"http://bla.com\" }," +
                        "isModifier: { value: \"true\" }, valueInteger: { value: \"14\" } } }";
            errors.Clear();
            result = (Extension)FhirParser.ParseElementFromJson(jsonWrong, errors);
            Assert.IsTrue(errors.Count() > 0);
            Assert.IsTrue(errors.ToString().Contains("Expected") &&
                        errors.ToString().Contains("Boolean"),errors.ToString());
        }

        [TestMethod]
        public void ParseSimpleComposite()
        {
            string xmlString = @"<testCoding id='x4' xmlns='http://hl7.org/fhir'>
                                    <system value='http://hl7.org/fhir/sid/icd-10' />
                                    <code value='G44.1' />
                                 </testCoding>";

            ErrorList errors = new ErrorList();
            Coding result = (Coding)FhirParser.ParseElementFromXml(xmlString, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual("x4", result.LocalId.ToString());
            Assert.AreEqual("G44.1", result.Code);
            Assert.AreEqual("http://hl7.org/fhir/sid/icd-10", result.System.ToString());
            Assert.IsNull(result.Display);

            string jsonString = "{ \"testCoding\" : { \"_id\" : \"x4\", " +
                    "\"system\": { \"value\" : \"http://hl7.org/fhir/sid/icd-10\" }, " +
                    "\"code\": { \"value\" : \"G44.1\" } } }";

            errors.Clear();
            result = (Coding)FhirParser.ParseElementFromJson(jsonString, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual("x4", result.LocalId);
            Assert.AreEqual("G44.1", result.Code);
            Assert.AreEqual("http://hl7.org/fhir/sid/icd-10", result.System.ToString());
            Assert.IsNull(result.Display);
        }


        [TestMethod]
        public void CompositeWithRepeatingElement()
        {
            string xmlString = @"
                <testCodeableConcept xmlns='http://hl7.org/fhir'>
                    <coding>
                        <system value=""http://hl7.org/fhir/sid/icd-10"" />
                        <code value=""R51"" />
                    </coding>
                    <coding id='1'>
                        <system value=""http://snomed.info/id"" />
                        <code value=""25064002"" />
                    </coding>
                </testCodeableConcept>";

            ErrorList errors = new ErrorList();
            CodeableConcept result = (CodeableConcept)FhirParser.ParseElementFromXml(xmlString, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(2, result.Coding.Count);
            Assert.AreEqual("R51", result.Coding[0].Code);
            Assert.AreEqual("25064002", result.Coding[1].Code);
            Assert.AreEqual("http://snomed.info/id", result.Coding[1].System.ToString());
            Assert.AreEqual("1", result.Coding[1].LocalId.ToString());


            string jsonString = @"{ ""testCodeableConcept"" : 
                    { ""coding"" : [ 
                        { ""system"" : { ""value"" : ""http://hl7.org/fhir/sid/icd-10"" },
                          ""code"" : { ""value"" : ""R51"" } },
                        { ""_id"" : ""1"", 
                          ""system"": { ""value"" : ""http://snomed.info/id"" },
                          ""code"" : { ""value"" : ""25064002"" } } ]
                    } }";

            errors.Clear();
            result = (CodeableConcept)FhirParser.ParseElementFromJson(jsonString, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(2, result.Coding.Count);
            Assert.AreEqual("R51", result.Coding[0].Code);
            Assert.AreEqual("25064002", result.Coding[1].Code);
            Assert.AreEqual("http://snomed.info/id", result.Coding[1].System.ToString());
            Assert.AreEqual("1", result.Coding[1].LocalId.ToString());
        }
        

        [TestMethod]
        public void ParseUnknownMembersAndRecover()
        {
            string xmlString = @"<testCodeableConcept xmlns='http://hl7.org/fhir'>
                    <coding>
                        <system value='http://hl7.org/fhir/sid/icd-10' />
                        <ewout>bla</ewout>
                        <code value='R51' />
                    </coding>
                    <coding id='1'>
                        <system value='http://snomed.info/id' />
                        <code value='25064002' />
                    </coding>
                    <grahame></grahame>
                    </testCodeableConcept>";

            ErrorList errors = new ErrorList();
            CodeableConcept result = (CodeableConcept)FhirParser.ParseElementFromXml(xmlString, errors);
            Assert.AreEqual(2,errors.Count);
            Assert.IsTrue(errors[0].ToString().Contains("ewout"));
            Assert.IsTrue(errors[1].ToString().Contains("grahame"));

            string jsonString = @"{ ""testCodeableConcept"" : 
                    { ""coding"" : [
                        { ""system"": { ""value"" : ""http://hl7.org/fhir/sid/icd-10"" }, 
                          ""ewout"" : ""bla"", 
                          ""code"" : { ""value"" : ""R51"" } 
                        },
                        { ""_id"" : ""1"", 
                          ""system"": { ""value"" : ""http://snomed.info/id"" }, 
                          ""code"" : { ""value"" : ""25064002""  }
                        } ],
                       ""grahame"" : { ""value"" : ""x"" } } }";

            errors.Clear();
            result = (CodeableConcept)FhirParser.ParseElementFromJson(jsonString, errors);
            Assert.AreEqual(2, errors.Count);
            Assert.IsTrue(errors[0].ToString().Contains("ewout"));
            Assert.IsTrue(errors[1].ToString().Contains("grahame"));
        }


        [TestMethod]
        public void ParseNameWithExtensions()
        {
            string xmlString =
                @"<Patient xmlns='http://hl7.org/fhir'>
                    <name>
                        <use value='official' />  
                        <given value='Regina' />
                        <prefix value='Dr.'>
                        <extension>
                            <url value='http://hl7.org/fhir/profile/@iso-20190' />
                            <valueCoding>
                                <system value='urn:oid:2.16.840.1.113883.5.1122' />       
                                <code value='AC' />
                            </valueCoding>
                        </extension>
                        </prefix>
                    </name>
                    <text>
                        <status value='generated' />
                        <div xmlns='http://www.w3.org/1999/xhtml'>Whatever</div>
                    </text>
                </Patient>";

            ErrorList errors = new ErrorList();
            Patient p = (Patient)FhirParser.ParseResourceFromXml(xmlString, errors);

            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsNotNull(p);
            Assert.AreEqual(1, p.Name[0].PrefixElement[0].Extension.Count());
        }


        [TestMethod]
        public void ParseLargeComposite()
        {
            XmlReader xr = XmlReader.Create(new StreamReader(@"..\..\..\..\..\publish\diagnosticreport-example.xml"));
            ErrorList errors = new ErrorList();
            DiagnosticReport rep = (DiagnosticReport)FhirParser.ParseResource(xr, errors);

            validateDiagReportAttributes(errors, rep);

            JsonTextReader jr = new JsonTextReader(new StreamReader(@"..\..\..\..\..\publish\diagnosticreport-example.json"));
            errors.Clear();
            rep = (DiagnosticReport)FhirParser.ParseResource(jr, errors);

            validateDiagReportAttributes(errors, rep);
        }

        private static void validateDiagReportAttributes(ErrorList errors, DiagnosticReport rep)
        {
            Assert.IsNotNull(rep);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());

            Assert.AreEqual("2011-03-04T08:30:00+11:00", rep.DiagnosticTime.ToString());
            Assert.AreEqual(17, rep.Contained.Count);
            Assert.AreEqual(17, rep.Results.Result.Count);

            Assert.IsNotNull(rep.Contained[1] as Observation);
            Observation obs1 = (Observation)rep.Contained[1];
            Assert.AreEqual(typeof(Quantity), obs1.Value.GetType());
            Assert.AreEqual((decimal)5.9, (obs1.Value as Quantity).Value.Value);

            Assert.IsNotNull(rep.Contained[8] as Observation);
            Observation obs8 = (Observation)rep.Contained[8];
            Assert.AreEqual("Neutrophils", obs8.Name.Coding[0].Display);
        }


        [TestMethod]
        public void ParsePerformance()
        {
            //string file = @"..\..\..\loinc.json";
            string file = @"..\..\..\..\..\publish\diagnosticreport-example.xml";
           
            int repeats = 20;

            System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();

            sw.Start();

            ErrorList errors = new ErrorList();

            for (int i = 0; i < repeats; i++)
            {
                errors.Clear();
                var xmlr = XmlReader.Create(file);
                //var jsonr = new JsonTextReader(new System.IO.StreamReader(file));
                //var rep = FhirParser.ParseResource(jsonr, errors);
                var rep = FhirParser.ParseResource(xmlr, errors);
            }

            Assert.IsTrue(errors.Count == 0, errors.ToString());

            sw.Stop();

            FileInfo f = new FileInfo(file);
            long bytesPerMs = f.Length * repeats / sw.ElapsedMilliseconds;

            File.WriteAllText(@"c:\temp\speedtest.txt", bytesPerMs.ToString() + " bytes per ms");
          //  Assert.IsTrue(bytesPerMs > 10*1024);       // > 10k per ms (Speed is of course very dependent on debug/release and machine)
        }

        [TestMethod]
        public void HandleCrapInFhirParser()
        {
            var errors = new ErrorList();
            FhirParser.ParseResourceFromJson("Crap!", errors);
            Assert.IsTrue(errors.Count > 0);

            errors.Clear();
            FhirParser.ParseResourceFromJson("{ \" Crap!", errors);
            Assert.IsTrue(errors.Count > 0);

            errors.Clear();
            FhirParser.ParseResourceFromXml("Crap", errors);
            Assert.IsTrue(errors.Count > 0);

            errors.Clear();
            FhirParser.ParseResourceFromXml("<Crap><cra", errors);
            Assert.IsTrue(errors.Count > 0);

        }
    }
}