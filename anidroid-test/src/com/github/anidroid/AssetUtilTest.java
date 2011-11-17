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

import android.content.res.AssetManager;
import android.test.InstrumentationTestCase;

public class AssetUtilTest extends InstrumentationTestCase {
	AssetUtil util;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		final AssetManager assetManager = getInstrumentation()
				.getContext().getAssets();
		util = new AssetUtil(assetManager);
	}

	public void testGetFilesList_FrameFilesCount() {
		assertEquals(5, util.getFileList("ajax-loader").size());
	}

	public void testGetFilesList_InvalidPath() {
		assertEquals(0, util.getFileList("not exists").size());
	}

	public void testGetFilesList_PathInFilename() {
		assertTrue(util.getFileList("ajax-loader").get(0).startsWith("ajax-loader"));
	}

	public void testGetFilesList_FullFilename() {
		assertEquals("ajax-loader" + "/frame_0.gif",
				util.getFileList("ajax-loader").get(1));
	}

	public void testOpen_FileExists() {
		assertNotNull(util.open("ajax-loader/ajax-loader.gif"));
	}

	public void testOpen_FileNotExists() {
		try {
			util.open("dir/some_file.txt");
			fail();
		} catch (final AniDroidException e) { }
	}
}
