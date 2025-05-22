private fun startCamera() {
    val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
    cameraProviderFuture.addListener({
        val cameraProvider = cameraProviderFuture.get()
        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(viewFinder.surfaceProvider)
        }
        val imageAnalyzer = ImageAnalysis.Builder().build().also {
            it.setAnalyzer(executor, FrameAnalyzer())
        }
        cameraProvider.bindToLifecycle(this, CameraSelector.DEFAULT_BACK_CAMERA, preview, imageAnalyzer)
    }, ContextCompat.getMainExecutor(this))
}
