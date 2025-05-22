class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }
    }
}


class OrientationOverlay(context: Context) : View(context) {
    var orientation: OrientationResult? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        orientation?.let {
            val centerX = width / 2f
            val centerY = height / 2f

            drawAxis(canvas, centerX, centerY, it.xAxis, Color.RED)
            drawAxis(canvas, centerX, centerY, it.yAxis, Color.GREEN)
            drawAxis(canvas, centerX, centerY, it.zAxis, Color.BLUE)
        }
    }

    private fun drawAxis(canvas: Canvas, cx: Float, cy: Float, axis: FloatArray, color: Int) {
        val scale = 100f
        val endX = cx + axis[0] * scale
        val endY = cy - axis[1] * scale
        val paint = Paint().apply {
            this.color = color
            strokeWidth = 5f
        }
        canvas.drawLine(cx, cy, endX, endY, paint)
    }
}
