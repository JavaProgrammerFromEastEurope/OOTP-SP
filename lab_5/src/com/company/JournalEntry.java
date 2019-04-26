package com.company;

public class JournalEntry {

    private String nameOfCollection;
    private String typeChangesOfCollection;
    private Student changedStudent;

    public JournalEntry(String nameOfCollection, String typeChangesOfCollection, Student changedStudent) {
        this.nameOfCollection = nameOfCollection;
        this.typeChangesOfCollection = typeChangesOfCollection;
        this.changedStudent = changedStudent;
    }

    @Override
    public String toString() {
        return String.format(" Название коллекции = '%s', тип коллекции = '%s', измененный объект = %s}",
                nameOfCollection, typeChangesOfCollection, changedStudent);
    }
}
