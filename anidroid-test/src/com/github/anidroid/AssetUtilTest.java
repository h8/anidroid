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
	AssetManager assetManager;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		assetManager = getInstrumentation().getContext().getAssets();
	}

	public void testGetFilesList_FrameFilesCount() {
		final String assetPath = "ajax-loader";
		final AssetUtil util = new AssetUtil(assetManager);

		assertEquals(5, util.getFileList(assetPath).size());
	}

	public void testGetFilesList_InvalidPath() {
		final String assetPath = "not exists";
		final AssetUtil util = new AssetUtil(assetManager);

		assertEquals(0, util.getFileList(assetPath).size());
	}

	public void testGetFilesList_PathInFilename() {
		final String assetPath = "ajax-loader";
		final AssetUtil util = new AssetUtil(assetManager);

		assertTrue(util.getFileList(assetPath).get(0).startsWith(assetPath));
	}

	public void testGetFilesList_FullFilename() {
		final String assetPath = "ajax-loader";
		final AssetUtil util = new AssetUtil(assetManager);

		assertEquals(assetPath + "/frame_0.gif",
				util.getFileList(assetPath).get(1));
	}

	public void testOpen_FileExists() {
		final String fpath = "ajax-loader/ajax-loader.gif";
		final AssetUtil util = new AssetUtil(assetManager);

		assertNotNull(util.open(fpath));
	}

	public void testOpen_FileNotExists() {
		final String fpath = "dir/some_file.txt";
		final AssetUtil util = new AssetUtil(assetManager);

		try {
			util.open(fpath);
			fail();
		} catch (final AniDroidException e) { }
	}
}
