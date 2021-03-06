package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2013, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Mon, Oct 28, 2013 15:39+1100 for FHIR v0.12

import java.util.*;

/**
 * A record of medication being taken by a patient, or that the medication has been given to a patient where the record is the result of a report from the patient, or another clinician.
 */
public class MedicationStatement extends Resource {

    public static class MedicationStatementDosageComponent extends BackboneElement {
        /**
         * The timing schedule for giving the medication to the patient.  The Schedule data type allows many different expressions, for example.  "Every  8 hours"; "Three times a day"; "1/2 an hour before breakfast for 10 days from 23-Dec 2011:";  "15 Oct 2013, 17 Oct 2013 and 1 Nov 2013".
         */
        protected Schedule timing;

        /**
         * A coded specification of the anatomic site where the medication first enters the body.
         */
        protected CodeableConcept site;

        /**
         * A code specifying the route or physiological path of administration of a therapeutic agent into or onto a subject.
         */
        protected CodeableConcept route;

        /**
         * A coded value indicating the method by which the medication is introduced into or onto the body. Most commonly used for injections.  Examples:  Slow Push; Deep IV.

Terminologies used often pre-coordinate this term with the route and or form of administration.
         */
        protected CodeableConcept method;

        /**
         * The amount of the therapeutic or other substance given at one administration event.
         */
        protected Quantity quantity;

        /**
         * Identifies the speed with which the substance is introduced into the subject. Typically the rate for an infusion. 200ml in 2 hours.
         */
        protected Ratio rate;

        /**
         * The maximum total quantity of a therapeutic substance that my be administered to a subject over the period of time. E.g. 1000mg in 24 hours.
         */
        protected Ratio maxDosePerPeriod;

      public MedicationStatementDosageComponent() {
        super();
      }

        public Schedule getTiming() { 
          return this.timing;
        }

        public MedicationStatementDosageComponent setTiming(Schedule value) { 
          this.timing = value;
          return this;
        }

        public CodeableConcept getSite() { 
          return this.site;
        }

        public MedicationStatementDosageComponent setSite(CodeableConcept value) { 
          this.site = value;
          return this;
        }

        public CodeableConcept getRoute() { 
          return this.route;
        }

        public MedicationStatementDosageComponent setRoute(CodeableConcept value) { 
          this.route = value;
          return this;
        }

        public CodeableConcept getMethod() { 
          return this.method;
        }

        public MedicationStatementDosageComponent setMethod(CodeableConcept value) { 
          this.method = value;
          return this;
        }

        public Quantity getQuantity() { 
          return this.quantity;
        }

        public MedicationStatementDosageComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        public Ratio getRate() { 
          return this.rate;
        }

        public MedicationStatementDosageComponent setRate(Ratio value) { 
          this.rate = value;
          return this;
        }

        public Ratio getMaxDosePerPeriod() { 
          return this.maxDosePerPeriod;
        }

        public MedicationStatementDosageComponent setMaxDosePerPeriod(Ratio value) { 
          this.maxDosePerPeriod = value;
          return this;
        }

        protected void listChildren(List<Property> childrenList) {
          super.listChildren(childrenList);
          childrenList.add(new Property("timing", "Schedule", "The timing schedule for giving the medication to the patient.  The Schedule data type allows many different expressions, for example.  'Every  8 hours'; 'Three times a day'; '1/2 an hour before breakfast for 10 days from 23-Dec 2011:';  '15 Oct 2013, 17 Oct 2013 and 1 Nov 2013'.", 0, java.lang.Integer.MAX_VALUE, timing));
          childrenList.add(new Property("site", "CodeableConcept", "A coded specification of the anatomic site where the medication first enters the body.", 0, java.lang.Integer.MAX_VALUE, site));
          childrenList.add(new Property("route", "CodeableConcept", "A code specifying the route or physiological path of administration of a therapeutic agent into or onto a subject.", 0, java.lang.Integer.MAX_VALUE, route));
          childrenList.add(new Property("method", "CodeableConcept", "A coded value indicating the method by which the medication is introduced into or onto the body. Most commonly used for injections.  Examples:  Slow Push; Deep IV.\n\nTerminologies used often pre-coordinate this term with the route and or form of administration.", 0, java.lang.Integer.MAX_VALUE, method));
          childrenList.add(new Property("quantity", "Quantity", "The amount of the therapeutic or other substance given at one administration event.", 0, java.lang.Integer.MAX_VALUE, quantity));
          childrenList.add(new Property("rate", "Ratio", "Identifies the speed with which the substance is introduced into the subject. Typically the rate for an infusion. 200ml in 2 hours.", 0, java.lang.Integer.MAX_VALUE, rate));
          childrenList.add(new Property("maxDosePerPeriod", "Ratio", "The maximum total quantity of a therapeutic substance that my be administered to a subject over the period of time. E.g. 1000mg in 24 hours.", 0, java.lang.Integer.MAX_VALUE, maxDosePerPeriod));
        }

      public MedicationStatementDosageComponent copy(MedicationStatement e) {
        MedicationStatementDosageComponent dst = new MedicationStatementDosageComponent();
        dst.timing = timing == null ? null : timing.copy();
        dst.site = site == null ? null : site.copy();
        dst.route = route == null ? null : route.copy();
        dst.method = method == null ? null : method.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.rate = rate == null ? null : rate.copy();
        dst.maxDosePerPeriod = maxDosePerPeriod == null ? null : maxDosePerPeriod.copy();
        return dst;
      }

  }

    /**
     * External identifier - FHIR will generate its own internal IDs (probably URLs) which do not need to be explicitly managed by the resource.  The identifier here is one that would be used by another non-FHIR system - for example an automated medication pump would provide a record each time it operated; an administration while the patient was off the ward might be made with a different system and entered after the event.  Particularly important if these records have to be updated.
     */
    protected List<Identifier> identifier = new ArrayList<Identifier>();

    /**
     * A link to a resource representing the person to whom the medication was given.
     */
    protected ResourceReference patient;

    /**
     * Set this to true if the record is saying that the medication was NOT administered.
     */
    protected Boolean wasNotGiven;

    /**
     * A code indicating why the administration has been negated.

Use only if isNegated is set to TRUE.
     */
    protected List<CodeableConcept> reasonNotGiven = new ArrayList<CodeableConcept>();

    /**
     * An interval of time during which the administration takes place.  For many administrations, such as swallowing a tablet the lower and upper values of the interval will be the same.
     */
    protected Period whenGiven;

    /**
     * Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.
     */
    protected ResourceReference medication;

    /**
     * An identifier or a link to a resource that identifies a device used in administering the medication to the patient.
     */
    protected List<ResourceReference> administrationDevice = new ArrayList<ResourceReference>();

    /**
     * Indicates how the medication is to be used by the patient.
     */
    protected List<MedicationStatementDosageComponent> dosage = new ArrayList<MedicationStatementDosageComponent>();

    public MedicationStatement() {
      super();
    }

    public List<Identifier> getIdentifier() { 
      return this.identifier;
    }

    // syntactic sugar
    public Identifier addIdentifier() { 
      Identifier t = new Identifier();
      this.identifier.add(t);
      return t;
    }

    public ResourceReference getPatient() { 
      return this.patient;
    }

    public MedicationStatement setPatient(ResourceReference value) { 
      this.patient = value;
      return this;
    }

    public Boolean getWasNotGiven() { 
      return this.wasNotGiven;
    }

    public MedicationStatement setWasNotGiven(Boolean value) { 
      this.wasNotGiven = value;
      return this;
    }

    public boolean getWasNotGivenSimple() { 
      return this.wasNotGiven == null ? null : this.wasNotGiven.getValue();
    }

    public MedicationStatement setWasNotGivenSimple(boolean value) { 
      if (value == false)
        this.wasNotGiven = null;
      else {
        if (this.wasNotGiven == null)
          this.wasNotGiven = new Boolean();
        this.wasNotGiven.setValue(value);
      }
      return this;
    }

    public List<CodeableConcept> getReasonNotGiven() { 
      return this.reasonNotGiven;
    }

    // syntactic sugar
    public CodeableConcept addReasonNotGiven() { 
      CodeableConcept t = new CodeableConcept();
      this.reasonNotGiven.add(t);
      return t;
    }

    public Period getWhenGiven() { 
      return this.whenGiven;
    }

    public MedicationStatement setWhenGiven(Period value) { 
      this.whenGiven = value;
      return this;
    }

    public ResourceReference getMedication() { 
      return this.medication;
    }

    public MedicationStatement setMedication(ResourceReference value) { 
      this.medication = value;
      return this;
    }

    public List<ResourceReference> getAdministrationDevice() { 
      return this.administrationDevice;
    }

    // syntactic sugar
    public ResourceReference addAdministrationDevice() { 
      ResourceReference t = new ResourceReference();
      this.administrationDevice.add(t);
      return t;
    }

    public List<MedicationStatementDosageComponent> getDosage() { 
      return this.dosage;
    }

    // syntactic sugar
    public MedicationStatementDosageComponent addDosage() { 
      MedicationStatementDosageComponent t = new MedicationStatementDosageComponent();
      this.dosage.add(t);
      return t;
    }

      protected void listChildren(List<Property> childrenList) {
        super.listChildren(childrenList);
        childrenList.add(new Property("identifier", "Identifier", "External identifier - FHIR will generate its own internal IDs (probably URLs) which do not need to be explicitly managed by the resource.  The identifier here is one that would be used by another non-FHIR system - for example an automated medication pump would provide a record each time it operated; an administration while the patient was off the ward might be made with a different system and entered after the event.  Particularly important if these records have to be updated.", 0, java.lang.Integer.MAX_VALUE, identifier));
        childrenList.add(new Property("patient", "Resource(Patient)", "A link to a resource representing the person to whom the medication was given.", 0, java.lang.Integer.MAX_VALUE, patient));
        childrenList.add(new Property("wasNotGiven", "boolean", "Set this to true if the record is saying that the medication was NOT administered.", 0, java.lang.Integer.MAX_VALUE, wasNotGiven));
        childrenList.add(new Property("reasonNotGiven", "CodeableConcept", "A code indicating why the administration has been negated.\n\nUse only if isNegated is set to TRUE.", 0, java.lang.Integer.MAX_VALUE, reasonNotGiven));
        childrenList.add(new Property("whenGiven", "Period", "An interval of time during which the administration takes place.  For many administrations, such as swallowing a tablet the lower and upper values of the interval will be the same.", 0, java.lang.Integer.MAX_VALUE, whenGiven));
        childrenList.add(new Property("medication", "Resource(Medication)", "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.", 0, java.lang.Integer.MAX_VALUE, medication));
        childrenList.add(new Property("administrationDevice", "Resource(Device)", "An identifier or a link to a resource that identifies a device used in administering the medication to the patient.", 0, java.lang.Integer.MAX_VALUE, administrationDevice));
        childrenList.add(new Property("dosage", "", "Indicates how the medication is to be used by the patient.", 0, java.lang.Integer.MAX_VALUE, dosage));
      }

      public MedicationStatement copy() {
        MedicationStatement dst = new MedicationStatement();
        dst.identifier = new ArrayList<Identifier>();
        for (Identifier i : identifier)
          dst.identifier.add(i.copy());
        dst.patient = patient == null ? null : patient.copy();
        dst.wasNotGiven = wasNotGiven == null ? null : wasNotGiven.copy();
        dst.reasonNotGiven = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : reasonNotGiven)
          dst.reasonNotGiven.add(i.copy());
        dst.whenGiven = whenGiven == null ? null : whenGiven.copy();
        dst.medication = medication == null ? null : medication.copy();
        dst.administrationDevice = new ArrayList<ResourceReference>();
        for (ResourceReference i : administrationDevice)
          dst.administrationDevice.add(i.copy());
        dst.dosage = new ArrayList<MedicationStatementDosageComponent>();
        for (MedicationStatementDosageComponent i : dosage)
          dst.dosage.add(i.copy(dst));
        return dst;
      }

      protected MedicationStatement typedCopy() {
        return copy();
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicationStatement;
   }


}

