AniDroid Library
================

AniDroid is a library for Android (tm) which 
helps to create frame animations.

About
-----

AniDroid will look for a frame images in assets folder
(and subdirectories) of your application. Each frame 
file should contain an index number:

    frame-10.png

Frames will be sorted (ascending) automatically by number,
files without index and extension will be ignored. There is
no need to put leading zeros to index.

Licence
-------

AniDroid is licensed under the terms of LGPL v.3 or later.



Usage
-----

Download and add anidroid.jar to your project, create
folder which will contain frame images in assets folder
of your application. Then create animation drawable:

    AnimationDrawable a = FrameAnimator
	.getInstance(getApplicationContext())
	.create("<your folder in assets>", 100, false);
    ((ImageView) findViewById(R.id.imageView))
	.setBackgroundDrawable(a);
    a.start();

See anidroid-example project for basic usage.


Building from source
--------------------

Building instruction:

    git clone git://github.com/h8/anidroid.git
    cd anidroid/anidroid
    android update project --path .
    ant dist
