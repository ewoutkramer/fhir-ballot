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
 * Demographics and qualification information for an individual who is directly or indirectly involved in the provisioning of healthcare.
 */
public class Practitioner extends Resource {

    public static class PractitionerQualificationComponent extends BackboneElement {
        /**
         * Coded representation of the qualification.
         */
        protected CodeableConcept code;

        /**
         * Period during which the qualification is valid.
         */
        protected Period period;

        /**
         * Organization that regulates and issues the qualification.
         */
        protected ResourceReference issuer;

      public PractitionerQualificationComponent() {
        super();
      }

      public PractitionerQualificationComponent(CodeableConcept code) {
        super();
        this.code = code;
      }

        public CodeableConcept getCode() { 
          return this.code;
        }

        public PractitionerQualificationComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        public Period getPeriod() { 
          return this.period;
        }

        public PractitionerQualificationComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        public ResourceReference getIssuer() { 
          return this.issuer;
        }

        public PractitionerQualificationComponent setIssuer(ResourceReference value) { 
          this.issuer = value;
          return this;
        }

        protected void listChildren(List<Property> childrenList) {
          super.listChildren(childrenList);
          childrenList.add(new Property("code", "CodeableConcept", "Coded representation of the qualification.", 0, java.lang.Integer.MAX_VALUE, code));
          childrenList.add(new Property("period", "Period", "Period during which the qualification is valid.", 0, java.lang.Integer.MAX_VALUE, period));
          childrenList.add(new Property("issuer", "Resource(Organization)", "Organization that regulates and issues the qualification.", 0, java.lang.Integer.MAX_VALUE, issuer));
        }

      public PractitionerQualificationComponent copy(Practitioner e) {
        PractitionerQualificationComponent dst = new PractitionerQualificationComponent();
        dst.code = code == null ? null : code.copy();
        dst.period = period == null ? null : period.copy();
        dst.issuer = issuer == null ? null : issuer.copy();
        return dst;
      }

  }

    /**
     * An identifier that applies to this person in this role.
     */
    protected List<Identifier> identifier = new ArrayList<Identifier>();

    /**
     * A name associated with the person.
     */
    protected HumanName name;

    /**
     * A contact detail for the practitioner, e.g. a telephone number or an email address.
     */
    protected List<Contact> telecom = new ArrayList<Contact>();

    /**
     * One or more addresses where the practitioner can be found or visited.
     */
    protected Address address;

    /**
     * Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.
     */
    protected CodeableConcept gender;

    /**
     * The date and time of birth for the practitioner.
     */
    protected DateTime birthDate;

    /**
     * Image of the person.
     */
    protected List<Attachment> photo = new ArrayList<Attachment>();

    /**
     * The organization that the practitioner represents.
     */
    protected ResourceReference organization;

    /**
     * The way in which the person represents the organization - what role do they have?.
     */
    protected List<CodeableConcept> role = new ArrayList<CodeableConcept>();

    /**
     * Specific specialty of the practitioner.
     */
    protected List<CodeableConcept> specialty = new ArrayList<CodeableConcept>();

    /**
     * The period during which the person is authorized to perform the service.
     */
    protected Period period;

    /**
     * Qualifications relevant to the provided service.
     */
    protected List<PractitionerQualificationComponent> qualification = new ArrayList<PractitionerQualificationComponent>();

    /**
     * A language the practitioner is able to use in patient communication.
     */
    protected List<CodeableConcept> communication = new ArrayList<CodeableConcept>();

    public Practitioner() {
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

    public HumanName getName() { 
      return this.name;
    }

    public Practitioner setName(HumanName value) { 
      this.name = value;
      return this;
    }

    public List<Contact> getTelecom() { 
      return this.telecom;
    }

    // syntactic sugar
    public Contact addTelecom() { 
      Contact t = new Contact();
      this.telecom.add(t);
      return t;
    }

    public Address getAddress() { 
      return this.address;
    }

    public Practitioner setAddress(Address value) { 
      this.address = value;
      return this;
    }

    public CodeableConcept getGender() { 
      return this.gender;
    }

    public Practitioner setGender(CodeableConcept value) { 
      this.gender = value;
      return this;
    }

    public DateTime getBirthDate() { 
      return this.birthDate;
    }

    public Practitioner setBirthDate(DateTime value) { 
      this.birthDate = value;
      return this;
    }

    public String getBirthDateSimple() { 
      return this.birthDate == null ? null : this.birthDate.getValue();
    }

    public Practitioner setBirthDateSimple(String value) { 
      if (value == null)
        this.birthDate = null;
      else {
        if (this.birthDate == null)
          this.birthDate = new DateTime();
        this.birthDate.setValue(value);
      }
      return this;
    }

    public List<Attachment> getPhoto() { 
      return this.photo;
    }

    // syntactic sugar
    public Attachment addPhoto() { 
      Attachment t = new Attachment();
      this.photo.add(t);
      return t;
    }

    public ResourceReference getOrganization() { 
      return this.organization;
    }

    public Practitioner setOrganization(ResourceReference value) { 
      this.organization = value;
      return this;
    }

    public List<CodeableConcept> getRole() { 
      return this.role;
    }

    // syntactic sugar
    public CodeableConcept addRole() { 
      CodeableConcept t = new CodeableConcept();
      this.role.add(t);
      return t;
    }

    public List<CodeableConcept> getSpecialty() { 
      return this.specialty;
    }

    // syntactic sugar
    public CodeableConcept addSpecialty() { 
      CodeableConcept t = new CodeableConcept();
      this.specialty.add(t);
      return t;
    }

    public Period getPeriod() { 
      return this.period;
    }

    public Practitioner setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    public List<PractitionerQualificationComponent> getQualification() { 
      return this.qualification;
    }

    // syntactic sugar
    public PractitionerQualificationComponent addQualification() { 
      PractitionerQualificationComponent t = new PractitionerQualificationComponent();
      this.qualification.add(t);
      return t;
    }

    public List<CodeableConcept> getCommunication() { 
      return this.communication;
    }

    // syntactic sugar
    public CodeableConcept addCommunication() { 
      CodeableConcept t = new CodeableConcept();
      this.communication.add(t);
      return t;
    }

      protected void listChildren(List<Property> childrenList) {
        super.listChildren(childrenList);
        childrenList.add(new Property("identifier", "Identifier", "An identifier that applies to this person in this role.", 0, java.lang.Integer.MAX_VALUE, identifier));
        childrenList.add(new Property("name", "HumanName", "A name associated with the person.", 0, java.lang.Integer.MAX_VALUE, name));
        childrenList.add(new Property("telecom", "Contact", "A contact detail for the practitioner, e.g. a telephone number or an email address.", 0, java.lang.Integer.MAX_VALUE, telecom));
        childrenList.add(new Property("address", "Address", "One or more addresses where the practitioner can be found or visited.", 0, java.lang.Integer.MAX_VALUE, address));
        childrenList.add(new Property("gender", "CodeableConcept", "Administrative Gender - the gender that the person is considered to have for administration and record keeping purposes.", 0, java.lang.Integer.MAX_VALUE, gender));
        childrenList.add(new Property("birthDate", "dateTime", "The date and time of birth for the practitioner.", 0, java.lang.Integer.MAX_VALUE, birthDate));
        childrenList.add(new Property("photo", "Attachment", "Image of the person.", 0, java.lang.Integer.MAX_VALUE, photo));
        childrenList.add(new Property("organization", "Resource(Organization)", "The organization that the practitioner represents.", 0, java.lang.Integer.MAX_VALUE, organization));
        childrenList.add(new Property("role", "CodeableConcept", "The way in which the person represents the organization - what role do they have?.", 0, java.lang.Integer.MAX_VALUE, role));
        childrenList.add(new Property("specialty", "CodeableConcept", "Specific specialty of the practitioner.", 0, java.lang.Integer.MAX_VALUE, specialty));
        childrenList.add(new Property("period", "Period", "The period during which the person is authorized to perform the service.", 0, java.lang.Integer.MAX_VALUE, period));
        childrenList.add(new Property("qualification", "", "Qualifications relevant to the provided service.", 0, java.lang.Integer.MAX_VALUE, qualification));
        childrenList.add(new Property("communication", "CodeableConcept", "A language the practitioner is able to use in patient communication.", 0, java.lang.Integer.MAX_VALUE, communication));
      }

      public Practitioner copy() {
        Practitioner dst = new Practitioner();
        dst.identifier = new ArrayList<Identifier>();
        for (Identifier i : identifier)
          dst.identifier.add(i.copy());
        dst.name = name == null ? null : name.copy();
        dst.telecom = new ArrayList<Contact>();
        for (Contact i : telecom)
          dst.telecom.add(i.copy());
        dst.address = address == null ? null : address.copy();
        dst.gender = gender == null ? null : gender.copy();
        dst.birthDate = birthDate == null ? null : birthDate.copy();
        dst.photo = new ArrayList<Attachment>();
        for (Attachment i : photo)
          dst.photo.add(i.copy());
        dst.organization = organization == null ? null : organization.copy();
        dst.role = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : role)
          dst.role.add(i.copy());
        dst.specialty = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : specialty)
          dst.specialty.add(i.copy());
        dst.period = period == null ? null : period.copy();
        dst.qualification = new ArrayList<PractitionerQualificationComponent>();
        for (PractitionerQualificationComponent i : qualification)
          dst.qualification.add(i.copy(dst));
        dst.communication = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : communication)
          dst.communication.add(i.copy());
        return dst;
      }

      protected Practitioner typedCopy() {
        return copy();
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Practitioner;
   }


}

