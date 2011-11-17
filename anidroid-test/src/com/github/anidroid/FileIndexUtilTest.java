/*
 *   Copyright 2011, Dmitry Stropaloff <dmitry.stropaloff@gmail.com>
 *
 *   This file is part of AniDroid project.
 *
 *   AniDroid is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as
 *   published by the Free Software Foundation, either version 3 of
 *   the License, or (at your option) any later version.
 *
 *   AniDroid is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with AniDroid.  If not, see
 *   <http://www.gnu.org/licenses/>.
 */

package com.github.anidroid;

import junit.framework.TestCase;

public class FileIndexUtilTest extends TestCase {
	FileIndexUtil util;

	@Override
	protected void setUp() throws Exception {
		util = new FileIndexUtil();

		super.setUp();
	}

	public void testExtractFileIndex_RegularFileName1() {
		assertEquals(8, (int) util.extractIndex("frame_8.gif"));
	}

	public void testExtractFileIndex_RegularFileName2() {
		assertEquals(18, (int) util.extractIndex("frame18.gif"));
	}

	public void testExtractFileIndex_RegularFileNameWithZero() {
		assertEquals(8, (int) util.extractIndex("frame_08.gif"));
	}

	public void testExtractFileIndex_TwoNumbersName() {
		assertEquals(107, (int) util.extractIndex("frame50_107.gif"));
	}

	public void testExtractFileIndex_OnlyNumber() {
		assertEquals(88, (int) util.extractIndex("88.gif"));
	}

	public void testExtractFileIndex_NoIndexNumber() {
		assertNull(util.extractIndex("frame.gif"));
	}

	public void testExtractFileIndex_NoExtension() {
		assertNull(util.extractIndex("frame15"));
	}
}
