package com.company;

import java.util.*;

public class Journal {

    private ArrayList<IStudentCountHandler> studentCountHandler = new ArrayList<IStudentCountHandler>();
    private ArrayList<IStudentReferenceHandler> studentReferenceHandler = new ArrayList<IStudentReferenceHandler>();

    private ArrayList<JournalEntry> journalEntries = new ArrayList<>();

    public  void addStudentCountListener(IStudentCountHandler listener) {
        if (!studentCountHandler.contains(listener)) {
            studentCountHandler.add(listener);
        }
    }

    public  void addStudentReferenceListener(IStudentReferenceHandler listener) {
        if (!studentReferenceHandler.contains(listener)) {
            studentReferenceHandler.add(listener);
        }
    }

    void studentsCountChanged(JournalEntry journalEntry){
        AddJournalEntry(journalEntry);
    }
    void studentReferenceChanged(JournalEntry journalEntry){
        AddJournalEntry(journalEntry);
    }
    private void AddJournalEntry(JournalEntry journalEntry) {
        this.journalEntries.add(journalEntry);
    } //добавление элементов

    @Override
    public String toString() {
        return "Journal{" +
                "studentCountHandler=" + studentCountHandler +
                ", studentReferenceHandler=" + studentReferenceHandler +
                ", journalEntries=" + journalEntries +
                '}';
    }
}
