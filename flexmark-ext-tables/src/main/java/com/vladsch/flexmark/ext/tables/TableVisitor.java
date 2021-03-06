package com.vladsch.flexmark.ext.tables;

public interface TableVisitor {
    void visit(final TableBlock node);
    void visit(final TableHead node);
    void visit(final TableSeparator node);
    void visit(final TableBody node);
    void visit(final TableRow node);
    void visit(final TableCell node);
    void visit(final TableCaption node);
}
