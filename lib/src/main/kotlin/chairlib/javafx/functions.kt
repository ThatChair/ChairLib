package chairlib.javafx

import javafx.scene.image.ImageView

/**
 * An ImageView scaling function. Learn more about ImageViews [here](<https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html>).
 *
 *  Scales the provided ImageView to either the given max height or max width, whichever would make the image smaller
 *
 *  @author by ThatChair
 *
 *  @return An ImageView scaled to either the maxHeight or maxWidth
 *  @since 0.0.4
 *
 *  @param imageView the ImageView to scale
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

/**
 * An ImageView scaling function. Learn more about ImageViews [here](<https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html>).
 *
 * Scales the provided ImageView to the specified height, maintaining aspect ratio
 *
 * @author by ThatChair
 *
 * @return The provided ImageView scaled to the specified height
 * @since 0.0.4
 *
 * @param imageView the ImageView to scale
 * @param height the desired height of the ImageView
 *
 */
fun scaleImageToHeight(imageView: ImageView, height: Double): ImageView {
    // Calculates the scaling factor based off of the image's height and the desired height
    val scalingFactor = height / imageView.image.height
    // uses the scaleImage function to scale the image with the calculated scaling factor and returns the scaled image
    return scaleImage(imageView, scalingFactor)
}


/**
 * An ImageView scaling function. Learn more about ImageViews [here](<https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html>).
 *
 * Scales the provided ImageView to the specified width while maintaining aspect ratio
 *
 * @author by ThatChair
 *
 * @return The provided ImageView scaled to the specified width
 * @since 0.0.4
 *
 * @param imageView the ImageView to scale
 * @param width the desired width of the ImageView
 *
 */
fun scaleImageToWidth(imageView: ImageView, width: Double): ImageView {
    // Calculates the scaling factor based off of the image's width and the desired width
    val scalingFactor = width / imageView.image.width
    // uses the scaleImage function to scale the image with the calculated scaling factor and returns the scaled image
    return scaleImage(imageView, scalingFactor)
}

/**
 * An ImageView scaling function. Learn more about ImageViews [here](<https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html>).
 *
 * Scales the provided ImageView to by the specified scaling factor
 *
 * @author by ThatChair
 *
 * @return The inputted ImageView scaled by the specified scaleFactor
 * @since 0.0.4
 *
 * @param imageView the ImageView to scale
 * @param scaleFactor the desired width
 *
 */
fun scaleImage(imageView: ImageView, scaleFactor: Double): ImageView {
    // Fits the width and height of the image to the original height multiplied by the given scale factor
    imageView.fitWidth = scaleFactor * imageView.image.width
    imageView.fitHeight = scaleFactor * imageView.image.height

    // Returns the scaled image
    return imageView
}
