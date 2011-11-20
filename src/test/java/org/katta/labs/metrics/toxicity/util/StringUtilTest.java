package org.katta.labs.metrics.toxicity.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class StringUtilTest {

    @Test
    public void shouldCollectTokens() {

        Map<String, String> map = StringUtil.collectParams("Class Data Abstraction Coupling is %{actual} (max allowed is %{limit}) classes .*",
                "Class Data Abstraction Coupling is 11 (max allowed is 10) classes [APIException, ArdenBaseLexer, ArdenBaseParser, ArdenBaseTreeParser, ByteArrayInputStream, Date, File, FileInputStream, FileOutputStream, MLMObject, OutputStreamWriter].");
        Assert.assertEquals("11", map.get("actual"));
        Assert.assertEquals("10", map.get("limit"));
    }
}
