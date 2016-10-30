package com.wikiraceassistant;

import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Tag to convert HTML code to space
 * @author Sebastian Greenholtz
 */
public class HTMLToSpaceTag extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        StringWriter sw = new StringWriter();
        getJspBody().invoke(sw);
        String html = sw.toString();
        String space = StringEscapeUtils.unescapeHtml(html);
        getJspContext().getOut().print(space);
    }
}
