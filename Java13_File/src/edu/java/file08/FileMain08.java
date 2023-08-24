package edu.java.file08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/*
 * IO Stream: 바이트 스트립(byte stream). 읽기/쓰기의 기본 단위는 byte 단위.
 *   모든 파일 형식(txt, jpg, mp4, docx, pptx, ...)에서 사용 가능.
 *   InputStream
 *   |__ FileInputStream, BufferdInputStream, ObjectInputStream, ...
 *   OutputStream
 *   |__ FileOutputStream, BufferOutputStream, ObjectOutputStream, ... 
 *   
 * Reader/Writer: 문자 스트림(character stream). 읽기/쓰기의 기본 단위는 "문자" 단위.
 *  텍스트 파일 형식(txt, csv, dat, ...)에서만 사용.
 *  Reader
 *  |__ InputStreamReader, BufferedReader
 *      |__ FileReader
 *   Writer
 *   |__ OutputStreamWriter, BufferedWriter
 *       |__ Filewriter
 *       
 *   Java 11 이전 버전까지는 FileReader와 FileWriter에서 인코딩 설정을 할 수 없었음.
 *   InputStreamReader, OutputStreamWriter가 인코딩 설정 기능을 가지고 있었음.
 *   Java 11 이후 버전부터는 FileReader와 FileWriter에서도 인코딩 설정을 할 수 있게 업데이트됨.
 *       
 * 인코딩(encoding): 문자에 해당하는 코드(정수)로 변환. (예) 'A' -> 65
 * 디코딩(decoding): 문자 코드(정수)에 해당하는 문자로 변환. (예) 65 -> 'A'
 * 운영체제(OS, Operating System)의 기본 인코딩 방식: 
 *   - 한글 MS-Windows: EUC-KR(MS949, CP949), 영문 MS-Windows: CP1252
 *   - MacOS, Linux: UTF-8 
 */

public class FileMain08 {

	public static void main(String[] args) {
		String ansiFile = "data/encoding-ansi.txt";
		String utf8File = "data/encoding-utf8.txt";
		
		// 1. Java 11 이전 버전에서 문자 스트림을 사용하는 방법:
		// FileReader, FileWriter는 권장하지 않음.
		try(
				// 1. byte stream 
				FileInputStream in = new FileInputStream(ansiFile); 
				// 2. 인코딩을 설정한 문자 스트림을 생성
				InputStreamReader reader = new InputStreamReader(in, "EUC-KR");
				// 3. 메모리 버퍼를 사용해서 읽기 속도를 빠르게 하기 위해서
				BufferedReader br = new BufferedReader(reader); 
		){
			while (true) {
				int read = br.read(); // 1글자를 읽음.
				if (read == -1) { // EOF
					break;
				}
				
				System.out.print(read + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		// Java 11 버전부터 문자 스트림을 사용하는 방법:
		// FileReader, FileWriter에서 인코딩 방식을 설정할 수 있게됨.
		try(
				// 1. FileReader를 생성할 때 인코딩 방식을 설정.
				FileReader reader = new FileReader(utf8File, Charset.forName("UTF-8"));
				// 2. 메모리 버퍼를 사용해서 읽기 속도를 빠르게.
				BufferedReader br = new BufferedReader(reader);
		){
			while (true) {
//				int read = br.read(); // 1글자씩 읽음.
//				if(read == -1) { // EOF
//					break;	
//				}
//				System.out.print((char) read); // 읽은 1글자를 콘솔에 출력.
				
				String line = br.readLine(); // 1줄씩 읽음.
				if(line == null) { // EOF
					break;
				}
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
