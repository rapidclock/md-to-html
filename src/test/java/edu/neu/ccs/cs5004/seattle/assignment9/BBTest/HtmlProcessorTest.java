package edu.neu.ccs.cs5004.seattle.assignment9.BBTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;

import edu.neu.ccs.cs5004.seattle.assignment9.impl.HtmlDocProcessor;

/**
 * @author RT
 */
public class HtmlProcessorTest {
	public final String IP_FILE_NAME = "ex_test.txt";
	public final String OP_FILE_NAME = "ex_test.html";
	public final String OP_FILE_CONTENTS = "<!DOCTYPE html>\n<html>\n<head><title>ex_test.txt" +
										   "</title></head>\n" +
										   "<body><h1>How to confuse *and* irritate people" +
										   "</h1>" +
										   "<p>\n</p>\n<p>This book covers the popular topics on " +
										   "how to confuse and irritate others. \n\n" +
										   "</p>" + "<h3>Disclaimer\n</h3>\n<p>\n</p>" +
										   "<p>You will be confused, maybe irritated, by the " +
										   "writings in this book. Achieving both emotions is the " +
										   "goal of the author." +
										   "\n\n" + "</p>\n<p>Answers inline \n\n</p>" +
										   "<blockquote><p>What is the time line for the project? " +
										   "\n" +
										   "</p>\n</blockquote>\n<p>\n</p>\n<p>We are aiming for " +
										   "the first on June.\n\n" + "</p>\n" +
										   "<blockquote><p>What are the resources allocated? " +
										   "\n</p>\n</blockquote>\n" +
										   "<blockquote><blockquote><p>Are you asking in terms of " +
										   "headcount or machines? \n" +
										   "</p>\n</blockquote>\n</blockquote>\n" +
										   "<blockquote><blockquote><blockquote><p>Headcount\n" +
										   "</p>\n</blockquote>\n</blockquote>\n</blockquote>\n<p" +
										   ">\n</p>" +
										   "<p>We are budgeted for 40 people.   \n\n" + "</p>" +
										   "<p>Mixing lists \n\n</p>\n<ol><li>one </li>\n<li>two " +
										   "<ul><li>inner one </li>\n<li>inner two <ol><li>inner " +
										   "inner one<li>"
										   + "<li>inner inner " +
										   "two</li>\n</ol></li>\n</ol></li>\n</ul></li>\n<li" +
										   ">three </li>\n</ol>\n<p>\n" + "</p>" + "<p>Another " +
										   "List\n\n" + "</p>\n<ol><li>one </li>\n<li>two " +
										   "</li>\n</ol>\n<ul><li> inner one </li>\n" +
										   "<ul><li> inner one </li>\n" + "</ul>\n" +
										   "<ol><li>inner inner one</li>\n<li>inner inner " +
										   "two</li>\n" +
										   "</ol>\n" + "<ul><li> inner three</li>\n" +
										   "</ul>\n<ol><li>three </li>\n</ol>\n" +
										   "<p>This concludes our parenthetical comment on " +
										   "irritating behaviour. \n\n" +
										   "</p>\n<hr>\n<p>\n</p>" + "<p>But we could not stop " +
										   "ourselves from making another parenthetical comment " +
										   "here \n\n" +
										   "</p>\n<hr>\n<p>\n</p>" + "<p>Nesting parenthetical " +
										   "arguments in written word causes confusion, or does " +
										   "it? \n\n" +
										   "</p>\n<p>****   Hello.\n\n" + "</p>\n" + "<p>So here " +
										   "is some <strong>bold</strong> text and some " +
										   "<em>italicized</em> text.\n\n</p>" +
										   "<p>We can also have <strong><em>this</em></strong>, as" +
										   " well as well as <em><strong>this</strong></em> and " +
										   "<strong>this <em>th</strong>ing</em>too*\n" +
										   "</strong>ing</em>too*\n\n</p>" + "</body></html>";
	private final String INPUT_FILE_CONTENTS = "# How to confuse *and* irritate people" + "\n\n" +
											   "This book covers the popular topics on how to " +
											   "confuse " +
											   "and irritate others. " + "\n\n" +
											   "### Disclaimer" + "\n\n" + "You will be confused," +
											   " " +
											   "maybe" +
											   " " +
											   "irritated, by the writings in " +
											   "this book. Achieving both emotions is the goal of " +
											   "the " +
											   "author."
											   + "\n\n" + "Answers inline " + "\n\n" + "> What is " +
											   "the " +
											   "time line for the project? " +
											   "" + "\n\n" + "We are aiming for the first on June" +
											   "." +
											   "\n\n" + "> What are the resources " +
											   "allocated? " + "\n"
											   + "> > Are you asking in terms of headcount or " +
											   "machines?" +
											   " " +
											   "" + "\n" + "> > > " +
											   "Headcount" + "\n\n" + "We are budgeted for 40 " +
											   "people. " +
											   " " +
											   " " +
											   "" + "\n\n" + "Mixing lists " +
											   "\n\n" + "1. one " + "\n" + "1. two "
											   + "\n" + "  * inner one " + "\n" + "  * inner two" +
											   " " +
											   "\n" + "    1. inner inner one" + "\n" + "    1" +
											   ". inner inner two" +
											   "\n" + "  * inner three" + "\n" + "1. three " +
											   "\n\n" +
											   "Another List" + "\n\n" + "1. one " + "\n" + "1" +
											   ". two "
											   + "\n" + "* inner one " + "\n" + "* inner two " +
											   "\n" +
											   "1. inner inner one" + "\n" + "1" +
											   ". inner inner two" +
											   "\n" + "* inner three" + "\n" + "1. three " +
											   "\n\n" +
											   "This concludes our parenthetical " +
											   "comment on irritating behaviour. "
											   + "\n\n" + "****" + "\n\n" + "But we could not stop" +
											   " " +
											   "ourselves from making another " +
											   "parenthetical comment here " + "\n\n" +
											   "******  " + "\n\n" + "Nesting parenthetical " +
											   "arguments " +
											   "in" +
											   " written word causes confusion, " +
											   "or does it? " + "\n\n" + "****   Hello."
											   + "\n\n" + "So here is some *bold* text and some " +
											   "_italicized_ text." + "\n\n" + "We can " +
											   "also " +
											   "have *_this_*, as well as well as _*this*_ and " +
											   "*this " +
											   "_th*ing_too*"
											   + "\n\n" + "You can see an example [Confused]" +
											   "(https://media.giphy" +
											   ".com/media/wi9yHmX7Sztuw/giphy.gif). " + "\n"
											   + "You can read more [here](https://en.wikipedia" +
											   ".org/wiki/Confusion)";
	String[] args = {IP_FILE_NAME};

	@Before
	public void setUp () throws Exception {
		File inpFile = new File(IP_FILE_NAME);
		PrintWriter printWriter = new PrintWriter(inpFile);
		printWriter.println(INPUT_FILE_CONTENTS);
	}

	@After
	public void tearDown () throws Exception {
		File inpFile = new File(IP_FILE_NAME);
		File opFile = new File(OP_FILE_NAME);
		if (inpFile.exists()) {
			inpFile.delete();
		}
		if (opFile.exists()) {
			opFile.delete();
		}
	}

	@Test
	public void TestMain () {
		HtmlDocProcessor.main(args);
	}
}
