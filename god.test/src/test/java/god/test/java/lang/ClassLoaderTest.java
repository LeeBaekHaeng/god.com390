package god.test.java.lang;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassLoaderTest {

	protected Logger egovLogger = LoggerFactory.getLogger(ClassLoaderTest.class);

//	@Test
	public void test() {
//		String name = java.lang.ClassLoader.class.getName().replace('.', '/') + ".class";
//		String name = egovframework.com.cmm.service.EgovCmmUseService.class.getName().replace('.', '/') + ".class";
		String name = egovframework.com.cmm.ComDefaultCodeVO.class.getName().replace('.', '/') + ".class";
		egovLogger.debug("name: {}", name);

		InputStream input = ClassLoader.getSystemResourceAsStream(name);
//		InputStream input = java.lang.ClassLoader.class.getClassLoader().getResourceAsStream(name);

		List<String> readLines = readLines(input);

		int i = 1;
		for (String readLine : readLines) {
			egovLogger.debug("i: {}, readLine: {}", i, readLine);
			i++;
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Test
	public void test2() {
		Class<?> clazz = egovframework.com.cmm.ComDefaultCodeVO.class;
		egovLogger.debug("clazz: {}", clazz);
		egovLogger.debug("getName: {}", clazz.getName());
		egovLogger.debug("getCanonicalName: {}", clazz.getCanonicalName());
		egovLogger.debug("getSimpleName: {}", clazz.getSimpleName());
		egovLogger.debug("getTypeName: {}", clazz.getTypeName());

		String name = clazz.getName().replace('.', '/') + ".class";
		egovLogger.debug("name: {}", name);

		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
//			egovLogger.debug("method: {}", method);
			egovLogger.debug("getName: {}", method.getName());
		}

		InputStream input = clazz.getClassLoader().getResourceAsStream(name);
//		InputStream input = ClassLoader.getSystemResourceAsStream(name);

		List<String> readLines = readLines(input);

		int i = 1;

		Map<Integer, String> map = new LinkedHashMap<>();

		for (String readLine : readLines) {
			egovLogger.debug("i: {}, readLine: {}", i, readLine);
			for (Method method : methods) {
				int indexOf = readLine.indexOf(method.getName());
				if (indexOf > -1 && readLine.indexOf("LineNumberTable") > -1) {
					egovLogger.debug("indexOf: {}", indexOf);
					map.put(indexOf, method.getName());
//					break;
				}
			}
			i++;
		}

		map.forEach((key, value) -> {
			egovLogger.debug("{}: {}", key, value);
		});

		List<Integer> list = new ArrayList(map.keySet());
		Collections.sort(list);
		for (Integer key : list) {
			egovLogger.debug("{}: {}", key, map.get(key));
		}
	}

	@Test
	public void test3() throws Exception {
		Class<?> clazz = egovframework.com.cmm.ComDefaultCodeVO.class;

		String name = clazz.getName().replace('.', '/') + ".class";
		InputStream source = clazz.getClassLoader().getResourceAsStream(name);

		File destination = File.createTempFile("god", null);
		destination.deleteOnExit();

		FileUtils.copyInputStreamToFile(source, destination);

		String s = FileUtils.readFileToString(destination);

		egovLogger.debug("{}", s);
		egovLogger.debug("LineNumberTable: {}", s.indexOf("LineNumberTable"));
		egovLogger.debug("SourceFile: {}", s.lastIndexOf("SourceFile"));

		String s2 = s.substring(s.indexOf("LineNumberTable"), s.lastIndexOf("SourceFile"));
		egovLogger.debug("{}", s2);

		Method[] methods = clazz.getDeclaredMethods();
		Map<Integer, String> map = new HashMap<>();
		for (Method method : methods) {
			egovLogger.debug("{}: {}", s.indexOf(method.getName()), method.getName());
			map.put(s.indexOf(method.getName()), method.getName());
		}

		map.forEach((key, value) -> {
			egovLogger.debug("{}: {}", key, value);
		});

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Integer> list = new ArrayList(map.keySet());
		Collections.sort(list);
		egovLogger.debug("god");
		for (Integer key : list) {
			egovLogger.debug("{}: {}", key, map.get(key));
		}
	}

	private List<String> readLines(InputStream input) {
		try {
			return IOUtils.readLines(input);
		} catch (IOException e) {
			egovLogger.error(e.getMessage());
			return null;
		}
	}

}
