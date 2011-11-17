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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class FrameUtilTest extends TestCase {
	FrameUtil util;

	@Override
	protected void setUp() throws Exception {
		util = new FrameUtil();

		super.setUp();
	}

	public void testExtractFrames_AllFrames() {
		assertEquals(5,
				util.extractFrames(createFrameList(5)).size());
	}

	public void testExtractFrames_SkipOne() {
		final List<String> frames = createFrameList(5);
		frames.add("folder/non-frame.png");

		assertEquals(5, util.extractFrames(frames).size());
	}

	public void testExtractFrames_NoFrames() {
		final List<String> frames =
				new ArrayList<String>(Arrays.
						asList(new String[] {"file1", "file2"}));

		try {
			util.extractFrames(frames);

			fail();
		} catch (final AniDroidException e) { }
	}

	public List<String> createFrameList(final int capacity) {
		final List<String> frames = new ArrayList<String>();

		for (int i = 0; i < capacity; i++) {
			frames.add(String.format("folder/frame-%d.png", i));
		}

		return frames;
	}
}
