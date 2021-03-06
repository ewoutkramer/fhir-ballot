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
 * Prospective warnings of potential issues when providing care to the patient.
 */
public class Alert extends Resource {

    public enum AlertStatus {
        active, // A current alert that should be displayed to a user. A system may use the category to determine which roles should view the alert.
        inactive, // The alert does not need to be displayed any more.
        error, // The alert was added in error, and should no longer be displayed.
        Null; // added to help the parsers
        public static AlertStatus fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return active;
        if ("inactive".equals(codeString))
          return inactive;
        if ("error".equals(codeString))
          return error;
        throw new Exception("Unknown AlertStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case active: return "active";
            case inactive: return "inactive";
            case error: return "error";
            default: return "?";
          }
        }
    }

  public static class AlertStatusEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return AlertStatus.active;
        if ("inactive".equals(codeString))
          return AlertStatus.inactive;
        if ("error".equals(codeString))
          return AlertStatus.error;
        throw new Exception("Unknown AlertStatus code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == AlertStatus.active)
        return "active";
      if (code == AlertStatus.inactive)
        return "inactive";
      if (code == AlertStatus.error)
        return "error";
      return "?";
      }
    }

    /**
     * Allows an alert to be divided into different categories like clinical, administrative etc.
     */
    protected CodeableConcept category;

    /**
     * Supports basic workflow.
     */
    protected Enumeration<AlertStatus> status;

    /**
     * The person who this alert concerns.
     */
    protected ResourceReference subject;

    /**
     * The person or device that created the alert.
     */
    protected ResourceReference author;

    /**
     * The textual component of the alert to display to the user.
     */
    protected String_ note;

    public Alert() {
      super();
    }

    public Alert(Enumeration<AlertStatus> status, ResourceReference subject, String_ note) {
      super();
      this.status = status;
      this.subject = subject;
      this.note = note;
    }

    public CodeableConcept getCategory() { 
      return this.category;
    }

    public Alert setCategory(CodeableConcept value) { 
      this.category = value;
      return this;
    }

    public Enumeration<AlertStatus> getStatus() { 
      return this.status;
    }

    public Alert setStatus(Enumeration<AlertStatus> value) { 
      this.status = value;
      return this;
    }

    public AlertStatus getStatusSimple() { 
      return this.status == null ? null : this.status.getValue();
    }

    public Alert setStatusSimple(AlertStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<AlertStatus>();
        this.status.setValue(value);
      return this;
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public Alert setSubject(ResourceReference value) { 
      this.subject = value;
      return this;
    }

    public ResourceReference getAuthor() { 
      return this.author;
    }

    public Alert setAuthor(ResourceReference value) { 
      this.author = value;
      return this;
    }

    public String_ getNote() { 
      return this.note;
    }

    public Alert setNote(String_ value) { 
      this.note = value;
      return this;
    }

    public String getNoteSimple() { 
      return this.note == null ? null : this.note.getValue();
    }

    public Alert setNoteSimple(String value) { 
        if (this.note == null)
          this.note = new String_();
        this.note.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> childrenList) {
        super.listChildren(childrenList);
        childrenList.add(new Property("category", "CodeableConcept", "Allows an alert to be divided into different categories like clinical, administrative etc.", 0, java.lang.Integer.MAX_VALUE, category));
        childrenList.add(new Property("status", "code", "Supports basic workflow.", 0, java.lang.Integer.MAX_VALUE, status));
        childrenList.add(new Property("subject", "Resource(Patient)", "The person who this alert concerns.", 0, java.lang.Integer.MAX_VALUE, subject));
        childrenList.add(new Property("author", "Resource(Practitioner|Patient|Device)", "The person or device that created the alert.", 0, java.lang.Integer.MAX_VALUE, author));
        childrenList.add(new Property("note", "string", "The textual component of the alert to display to the user.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      public Alert copy() {
        Alert dst = new Alert();
        dst.category = category == null ? null : category.copy();
        dst.status = status == null ? null : status.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.author = author == null ? null : author.copy();
        dst.note = note == null ? null : note.copy();
        return dst;
      }

      protected Alert typedCopy() {
        return copy();
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Alert;
   }


}

