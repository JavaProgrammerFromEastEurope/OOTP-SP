package com.company;

import java.util.EventListener;

// Roughly analogous to .NET delegate
interface StudentListHandler extends EventListener {
    void StudentListHandler(StudentListHandlerEventArgs args);
}
