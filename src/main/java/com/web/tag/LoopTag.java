package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class LoopTag implements IterationTag {

    private PageContext pageContext;
    private Tag paramTag;
    private Integer count;

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        paramTag = tag;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public Tag getParent() {
        return paramTag;
    }

    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doAfterBody() throws JspException {
        --count;
        if (count == 0) {
            return Tag.SKIP_BODY;
        }
        return IterationTag.EVAL_BODY_AGAIN;

    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
    }

}
