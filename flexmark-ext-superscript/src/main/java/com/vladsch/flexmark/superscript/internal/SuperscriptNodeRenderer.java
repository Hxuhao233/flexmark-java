package com.vladsch.flexmark.superscript.internal;

import com.vladsch.flexmark.html.CustomNodeRenderer;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.superscript.Superscript;
import com.vladsch.flexmark.superscript.SuperscriptExtension;
import com.vladsch.flexmark.util.options.DataHolder;

import java.util.HashSet;
import java.util.Set;

public class SuperscriptNodeRenderer implements NodeRenderer {
    private final String superscriptStyleHtmlOpen;
    private final String superscriptStyleHtmlClose;

    public SuperscriptNodeRenderer(DataHolder options) {
        superscriptStyleHtmlOpen = SuperscriptExtension.SUPERSCRIPT_STYLE_HTML_OPEN.getFrom(options);
        superscriptStyleHtmlClose = SuperscriptExtension.SUPERSCRIPT_STYLE_HTML_CLOSE.getFrom(options);
    }

    @Override
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        Set<NodeRenderingHandler<?>> set = new HashSet<NodeRenderingHandler<?>>();
        // @formatter:off
        set.add(new NodeRenderingHandler<Superscript>(Superscript.class, new CustomNodeRenderer<Superscript>() { @Override public void render(Superscript node, NodeRendererContext context, HtmlWriter html) { SuperscriptNodeRenderer.this.render(node, context, html); } }));
        // @formatter:on
        return set;
    }

    private void render(Superscript node, NodeRendererContext context, HtmlWriter html) {
        if (superscriptStyleHtmlOpen == null || superscriptStyleHtmlClose == null) {
            html.withAttr().tag("sup");
            context.renderChildren(node);
            html.tag("/sup");
        } else {
            html.raw(superscriptStyleHtmlOpen);
            context.renderChildren(node);
            html.raw(superscriptStyleHtmlClose);
        }
    }

    public static class Factory implements NodeRendererFactory {
        @Override
        public NodeRenderer create(final DataHolder options) {
            return new SuperscriptNodeRenderer(options);
        }
    }
}
