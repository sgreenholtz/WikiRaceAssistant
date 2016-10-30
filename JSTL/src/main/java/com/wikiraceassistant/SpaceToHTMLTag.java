package com.wikiraceassistant;

import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Tag to convert Spaces into Hex code &#32;
 * @author Sebastian Greenholtz
 */
public class SpaceToHTMLTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        StringWriter sw = new StringWriter();
        getJspBody().invoke(sw);
        String space = sw.toString();
        String html = StringEscapeUtils.escapeHtml(space);
        getJspContext().getOut().print(html);
    }
}
