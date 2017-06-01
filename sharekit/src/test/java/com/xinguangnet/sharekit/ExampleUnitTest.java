package com.xinguangnet.sharekit;

import org.junit.Test;

import static org.junit.Assert.*;

import com.xinguangnet.sharekit.action.TextShareAction;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testTextShare(){
        TextShareAction mTextShareAction = new TextShareAction.Builder().setTitle("123").setContent("内容").build();

    }
}