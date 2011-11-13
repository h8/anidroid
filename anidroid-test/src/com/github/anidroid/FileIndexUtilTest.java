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

import android.test.AndroidTestCase;

public class FileIndexUtilTest extends AndroidTestCase {
	public void testExtractFileIndex_RegularFileName1() {
		final String fname = "frame_8.gif";
		final FileIndexUtil util = new FileIndexUtil();

		assertEquals(8, (int) util.extractIndex(fname));
	}

	public void testExtractFileIndex_RegularFileName2() {
		final String fname = "frame18.gif";
		final FileIndexUtil util = new FileIndexUtil();

		assertEquals(18, (int) util.extractIndex(fname));
	}

	public void testExtractFileIndex_TwoNumbersName() {
		final String fname = "frame50_107.gif";
		final FileIndexUtil util = new FileIndexUtil();

		assertEquals(107, (int) util.extractIndex(fname));
	}

	public void testExtractFileIndex_OnlyNumber() {
		final String fname = "88.gif";
		final FileIndexUtil util = new FileIndexUtil();

		assertEquals(88, (int) util.extractIndex(fname));
	}

	public void testExtractFileIndex_NoIndexNumber() {
		final String fname = "frame.gif";
		final FileIndexUtil util = new FileIndexUtil();

		assertNull(util.extractIndex(fname));
	}

	public void testExtractFileIndex_NoExtension() {
		final String fname = "frame15";
		final FileIndexUtil util = new FileIndexUtil();

		assertNull(util.extractIndex(fname));
	}
}
