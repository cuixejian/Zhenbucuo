package com.webtest.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

class HtmlUtils{
    private static String extractText(Node node){
        /* TextNode直接返回结果 */
        if(node instanceof TextNode){    
            return ((TextNode) node).text();  
        }   
        /* 非TextNode的Node，遍历其孩子Node */
        List<Node> children = node.childNodes();   
        StringBuffer buffer = new StringBuffer();    
        for (Node child: children) {   
            buffer.append(extractText(child)); 
        }   
        return buffer.toString();
    }
    /* 使用jsoup解析html并转化为提取字符串*/
    public static String html2Str(String url) throws IOException{
    	File input = new File("D:/lianxi/Java/auto2020/test-output/aResult/test.html");
    	Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");   
        return extractText(doc);
    }
}

