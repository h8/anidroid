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

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

/**
 * @author Dmitry Stropaloff <dmitry.stropaloff@gmail.com>
 * @version 0.1
 * @since 2011-11-13
 * @see <a href="https://github.com/h8/anidroid">AniDroid on github</a>
 */
public final class FrameAnimator {
	Context context;
	FrameUtil frameUtil;
	AssetUtil assetUtil;

	/**
	 * Create and return FrameAnimator instance
	 *
	 * @param context  Android context object
	 *
	 * @return FrameAnimator instance
	 */
	public static FrameAnimator getInstance(final Context context) {
		final FrameAnimator animator = new FrameAnimator();

		animator.context = context;
		animator.frameUtil = new FrameUtil();
		animator.assetUtil = new AssetUtil(context.getAssets());

		return animator;
	}

	/**
	 * Create and return animation drawable
	 *
	 * @param assetsFramesPath Path to folder with animation frames
	 *                         relative to "assets" folder of android
	 *                         application
	 * @param defaultDuration  How long in milliseconds a single frame
	 *                         should appear
	 * @param oneShot          Play once (true) or repeat (false)
	 *
	 * @return AnimationDrawable instance
	 */
	public AnimationDrawable create(final String assetsFramesPath,
			final int defaultDuration, final boolean oneShot) {
		final List<String> files = assetUtil.getFileList(assetsFramesPath);
		final SortedMap<Integer, String> frames = frameUtil.extractFrames(files);

		final AnimationDrawable animationDrawable = new AnimationDrawable();
		animationDrawable.setOneShot(oneShot);

		for (final Integer key : frames.keySet()) {
			final Bitmap frame = BitmapFactory
					.decodeStream(assetUtil.open(frames.get(key)));
			animationDrawable.addFrame(new BitmapDrawable(frame), defaultDuration);
		}

		return animationDrawable;
	}
}
