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

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

class FrameUtil {
	final FileIndexUtil indexUtil;

	public FrameUtil() {
		indexUtil = new FileIndexUtil();
	}

	public SortedMap<Integer, String> extractFrames(final List<String> fnames) {
		final SortedMap<Integer, String> frames =
				new TreeMap<Integer, String>();

		for (final String fname : fnames) {
			final Integer index = indexUtil.extractIndex(fname);
			if (index != null) frames.put(index, fname);
		}

		if (frames.size() > 0)
			return frames;
		else
			throw new AniDroidException("No frame files found");
	}

}
