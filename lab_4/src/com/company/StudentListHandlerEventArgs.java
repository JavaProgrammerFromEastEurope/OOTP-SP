package com.company;


import java.util.EventObject;

    // Roughly analogous to .NET EventArgs
class StudentListHandlerEventArgs extends EventObject{

    private String nameOfCollection;
    private String typeChangesOfCollection;
    private Student changedStudent;

    public StudentListHandlerEventArgs(Object source, String nameOfCollection, String typeChangesOfCollection, Student changedStudent) {
            super(source);
            this.nameOfCollection        = nameOfCollection;
            this.typeChangesOfCollection = typeChangesOfCollection;
            this.changedStudent          = changedStudent;
        }

    public String getNameOfCollection() {
            return nameOfCollection;
    }
    public String getTypeChangesOfCollection() {
            return typeChangesOfCollection;
    }
    public Student getChangedStudent() {
            return changedStudent;
    }


    public StudentListHandlerEventArgs(Object source){
        this(source,"","", new Student());
    }
    public StudentListHandlerEventArgs( String nameOfCollection, String typeChangesOfCollection, Student changedStudent){
        this(null, nameOfCollection, typeChangesOfCollection, changedStudent);
    }
    public String getMessage(){
        return nameOfCollection + " " + typeChangesOfCollection + " " + changedStudent;
    }
    @Override
    public String toString() {
        return String.format(" Название коллекции = '%s', тип коллекции = '%s', измененный объект = '%s'",
                nameOfCollection, typeChangesOfCollection, changedStudent);
    }
}
