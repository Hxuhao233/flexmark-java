package com.vladsch.flexmark.samples;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.profiles.pegdown.Extensions;
import com.vladsch.flexmark.profiles.pegdown.PegdownOptionsAdapter;
import com.vladsch.flexmark.util.options.DataHolder;

public class PegdownOptions {
    static final DataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(
            Extensions.ALL
    );

    static final Parser PARSER = Parser.builder(OPTIONS).build();
    static final HtmlRenderer RENDERER = HtmlRenderer.builder(OPTIONS).build();

    // use the PARSER to parse and RENDERER to render with pegdown compatibility
}
