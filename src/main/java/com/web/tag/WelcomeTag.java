package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/*
Tag:
<my:welcome username="yun">
    現在時刻: <%=new Date()%>
</my:welcome>
OUTPUT:
歡迎Yun光臨
現在時刻: .....
 */
public class WelcomeTag implements Tag {

    private PageContext pageContext;
    private Tag parenTag;
    private String username;

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parenTag = tag;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Tag getParent() {
        return parenTag;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        try {
            out.println("歡迎光臨" + username + " ");
        } catch (Exception e) {
        }
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }

}
