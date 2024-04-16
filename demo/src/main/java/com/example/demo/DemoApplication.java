package com.example.demo;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		genFile();
	}

	private static void genFile() {
		// 设置要生成的 PDF 文件的页数
        int numberOfPages = 600;
        // 设置每页文本的长度（大约为 200 KB）
        int textLength = 20000000;

        try {
            // 创建一个 PDDocument 对象
            PDDocument document = new PDDocument();

            // 生成指定页数的页面并添加到文档中
            for (int i = 0; i < numberOfPages; i++) {
                PDPage page = new PDPage();
                document.addPage(page);

                // 向页面添加文本内容
                PDPageContentStream contentStream = new PDPageContentStream(document, page);
                StringBuilder text = new StringBuilder();
                for (int j = 0; j < textLength; j++) {
                    text.append("A"); // 添加大量文本内容
                }
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText(text.toString());
                contentStream.endText();
                contentStream.close();
            }

            // 生成的文件名和路径
            String fileName = "large_file.pdf";

            // 保存 PDF 文件
            File file = new File(fileName);
            OutputStream outputStream = new FileOutputStream(file);
            document.save(outputStream);
            document.close();
            outputStream.close();

            // 打印文件信息
            System.out.println("PDF 文件已生成：" + file.getAbsolutePath());
            System.out.println("文件大小：" + file.length() / (1024 * 1024) + " MB");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
