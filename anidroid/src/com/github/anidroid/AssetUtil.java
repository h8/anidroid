/*
 *   Copyright 2011, Dmitry Stropaloff <dmitry.stropaloff@gmail.com>
 *
 *   This file is part of AniDroid project.
 *
 *   AniDroid is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Lesser General Public License as
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.res.AssetManager;
import android.util.Log;

class AssetUtil {
	final AssetManager assetManager;

	public AssetUtil(final AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	public List<String> getFileList(final String assetPath) {
		try {
			final List<String> files = new ArrayList<String>();

			for (final String fname : assetManager.list(assetPath)) {
				files.add((new File(assetPath, fname)).toString());
			}

			return files;
		} catch (final IOException e) {
			Log.d(getClass().getPackage().getName(),
					String.format("Can't read assets path: '%s'", assetPath));
		}

		return Collections.emptyList();
	}

	public InputStream open(final String filePath) {
		try {
			return assetManager.open(filePath);
		} catch (final IOException e) {
			final String message = String.format("Can't read file '%s' from assets", filePath);
			Log.d(getClass().getPackage().getName(), message);
			throw new AniDroidException(message);
		}
	}
}
