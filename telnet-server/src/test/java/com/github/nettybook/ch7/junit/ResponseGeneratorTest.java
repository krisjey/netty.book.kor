package com.github.nettybook.ch7.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResponseGeneratorTest {

    @Test
    public void testZeroLengthString() {
        String request = "";
        
        ResponseGenerator generator = new ResponseGenerator(request);
        assertNotNull(generator);

        assertNotNull(generator.response());
        assertEquals("명령을 입력해 주세요.\r\n", generator.response());

        assertFalse(generator.isClose());
    }

    @Test
    public void testHi() {
        String request = "hi";
        
        ResponseGenerator generator = new ResponseGenerator(request);
        assertNotNull(generator);

        assertNotNull(generator.response());
        assertEquals("입력하신 명령이 '" + request + "' 입니까?\r\n", generator.response());
        
        assertFalse(generator.isClose());
    }

    @Test
    public void testBye() {
        String request = "bye";
        
        ResponseGenerator generator = new ResponseGenerator(request);
        assertNotNull(generator);

        assertNotNull(generator.response());
        assertEquals("좋은 하루 되세요!\r\n", generator.response());
        assertTrue(generator.isClose());
    }
}
