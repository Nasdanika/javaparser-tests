package org.nasdanika.javaparser.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ParserConfiguration.LanguageLevel;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class JavaParserTests {
	
	private static final String INTERFACE_WITH_PRIVATE_METHOD_CODE = """
					package org.nasdanika.graph;
					
					public interface Element {
					
						private void matchPredicate(Object obj, String expr) {
						
						}
						
					}
			""";

	@Test
	public void testPrivateInterfaceMethod() {
		ParserConfiguration parserConfiguration = new ParserConfiguration();
		parserConfiguration.setLanguageLevel(LanguageLevel.JAVA_17);
		JavaParser parser = new JavaParser(parserConfiguration);
		ParseResult<CompilationUnit> parseResult = parser.parse(INTERFACE_WITH_PRIVATE_METHOD_CODE);
		System.out.println(parseResult.getProblems());
		System.out.println(parseResult.isSuccessful());
		System.out.println(parseResult.getResult());
		assertTrue(parseResult.isSuccessful(), parseResult.getProblems().toString());
	}

	@Test
	public void testPrivateInterfaceMethodStatic() {
		StaticJavaParser.getParserConfiguration().setLanguageLevel(LanguageLevel.JAVA_17);
		StaticJavaParser.parse(INTERFACE_WITH_PRIVATE_METHOD_CODE);
	}
	
}
