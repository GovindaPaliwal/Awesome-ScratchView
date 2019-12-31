
# Awesome ScratchView  -  Android Library
  
  
Introduction
------

Awesome ScratchView is scratch cards like views which are scratched to reveal the information they hide. There
are two types of ScratchView
* <a href='https://github.com//views/ScratchImageView.java'> ScratchImageView </a>
    - A Child of ImageView which hide the image. Scratching over the view will reveal the hidden image.

* <a href='https://github.com//ScratchTextView.java'> ScratchTextView </a>
    - A Child of TextView which hide the text. Scratching over the view will reveal the hidden text.

Sample Screen
------

### Methods

Both the views have following five methods which are useful to set image and reveal or determine whether revealed and listener during revealing the hidden text/image.

* ```setScratchImage(R.drawable.scratch_image)``` - set your drwable image for scratch card. (Optional)
* ```setStrokeWidth``` - you can set touch Width for scratch. (Optional)
* ```isRevealed()``` - tells whether the text/image has been revealed.
* ```reveal()``` - reveals the image/text if not revealed yet.
* ```setRevealListener(IRevealListener)``` - a callback listener interface which gets called back when user reveals the text/image
through onReveal() method.

How To Use
--------
Adding to your project
------------------------

- Add the following configuration in your build.gradle file.

```gradle
dependencies {
    implementation 'com.gpfreetech:AwesomeScratchView:1.0'  // 1.0 is current stable version
}
```

### A. ScratchTextView

##### XML

```xml
<com.gpfreetech.views.ScratchTextView
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:gravity="center|end"
  android:text="Here Your Text"
  android:textSize="TEXT_SIZE"
  android:textStyle="bold" />

```

##### JAVA

```java
ScratchTextView scratchTextView = new ScratchTextView(this);
// or
ScratchTextView scratchTextView = (ScratchTextView) findViewById(R.id.view);

scratchTextView.setRevealListener(new ScratchTextView.IRevealListener() {
    @Override
    public void onRevealed(ScratchTextView view) {
        //on reveal
    }

    @Override
    public void onRevealPercentChangedListener(ScratchTextView view, float percent) {
        // on text percent reveal
    }
});
```

### B. ScratchImageView

##### XML

```xml
<com.gpfreetech.views.ScratchImageView
  android:id="@+id/sample_image"
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:background="@android:color/white"
  android:src="@drawable/img"
  />
```

##### JAVA

```java
ScratchImageView scratchImageView = new ScratchImageView(this);
  // or
ScratchImageView scratchImageView = (ScratchImageView) findViewById(R.id.view);

scratchImageView.setRevealListener(new ScratchImageView.IRevealListener() {
    @Override
    public void onRevealed(ScratchImageView view) {
        // on reveal
    }
    @Override
    public void onRevealPercentChangedListener(ScratchImageView view, float percent) {
        // on image percent reveal
    }
});
```

##### Extra Method for customization (Both are optional)
```java
// To set your drwable image for scratch card.
scratchTextView.setScratchImage(R.drawable.scratch_image)
```
```java
// You can set touch Width for scratch.
scratchTextView.setStrokeWidth(FLOAT_VALUE)
```

Developed By
------------

* Gpfreetech - <gpfreetech@gmail.com>


License
--------
```
Copyright 2018 gpfreetech

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```