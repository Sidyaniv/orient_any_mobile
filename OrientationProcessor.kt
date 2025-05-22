val interpreter = Interpreter(loadModelFile(context, "model.tflite"))

fun analyzeImage(bitmap: Bitmap): OrientationResult {
    val input = preprocess(bitmap)  // Resize, normalize
    val output = Array(1) { FloatArray(6) }  // Например: 3 вектора (оси x, y, z)
    interpreter.run(input, output)
    return postprocess(output)
}
