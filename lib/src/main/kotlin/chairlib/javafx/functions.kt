package chairlib.javafx

import javafx.scene.image.ImageView

/**
 *  An image scaling function
 *
 *  Scales the provided image to either the given max height or max width, whichever would make the image smaller
 *
 *  @param imageView the image to scale
 *  @param maxHeight the maximum height of the image
 *  @param maxWidth the maximum width of the image
 */
fun autoScaleImage(imageView: ImageView, maxHeight: Double, maxWidth: Double): ImageView {
    // Determines and saves the aspect ratio of the given image.
    val aspectRatio = imageView.image.width / imageView.image.height

    // Uses the aspect ratio of the imageViews to determine the scale factor to use
    val scaleFactor = if (maxHeight * aspectRatio < maxWidth / aspectRatio) maxHeight / imageView.image.height else maxWidth / imageView.image.width

    // Returns the imageView scaled to the scale factor.
    return scaleImage(imageView, scaleFactor)
}

// Returns a scaled ImageView with given height and a preserved aspect ratio
fun scaleImageToHeight(image: ImageView, height: Double): ImageView {
    // Calculates the scaling factor based off of the image's height and the desired height
    val scalingFactor = height / image.image.height
    // uses the scaleImage function to scale the image with the calculated scaling factor and returns the scaled image
    return scaleImage(image, scalingFactor)
}
// Returns a scaled ImageView with given width and a preserved aspect ratio
fun scaleImageToWidth(image: ImageView, width: Double): ImageView {
    // Calculates the scaling factor based off of the image's width and the desired width
    val scalingFactor = width / image.image.width
    // uses the scaleImage function to scale the image with the calculated scaling factor and returns the scaled image
    return scaleImage(image, scalingFactor)
}


// Scales an ImageView to a given scale factor
fun scaleImage(image: ImageView, scaleFactor: Double): ImageView {
    // Fits the width and height of the image to the original height multiplied by the given scale factor
    image.fitWidth = scaleFactor * image.image.width
    image.fitHeight = scaleFactor * image.image.height

    // Returns the scaled image
    return image
}
