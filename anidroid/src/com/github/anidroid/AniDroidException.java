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

public class AniDroidException extends RuntimeException {
	private static final long serialVersionUID = 448400889324818638L;

	public AniDroidException() {
		super();
	}

	public AniDroidException(final String message){
		super(message);
	}
}
