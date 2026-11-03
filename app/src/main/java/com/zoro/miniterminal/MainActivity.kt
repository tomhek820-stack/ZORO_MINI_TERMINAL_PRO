package com.zoro.miniterminal

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {
    private val green = Color.rgb(0, 255, 120)
    private val background = Color.rgb(8, 12, 10)
    private lateinit var output: TextView
    private lateinit var command: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = background
        window.navigationBarColor = background
        window.decorView.setBackgroundColor(background)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 24, 20, 18)
            setBackgroundColor(background)
        }

        val title = TextView(this).apply {
            text = "ZORO MINI TERMINAL PRO"
            textSize = 20f
            setTextColor(green)
            setTypeface(Typeface.MONOSPACE, Typeface.BOLD)
            gravity = Gravity.CENTER
        }
        root.addView(title, matchWrap())

        val subtitle = TextView(this).apply {
            text = "واجهة الطرفية — الإصدار الأول"
            textSize = 13f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 8, 0, 18)
        }
        root.addView(subtitle, matchWrap())

        output = TextView(this).apply {
            text = "ZORO MINI TERMINAL\n\nهذه نسخة البداية.\nاكتب help لعرض الأوامر المتاحة.\n"
            textSize = 14f
            setTextColor(green)
            typeface = Typeface.MONOSPACE
            setPadding(12, 12, 12, 12)
        }
        val scroll = ScrollView(this).apply {
            setBackgroundColor(Color.rgb(15, 20, 17))
            addView(output)
        }
        root.addView(scroll, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f
        ))

        command = EditText(this).apply {
            hint = "اكتب أمرًا..."
            setHintTextColor(Color.GRAY)
            setTextColor(Color.WHITE)
            textSize = 15f
            typeface = Typeface.MONOSPACE
            setSingleLine(true)
            setBackgroundColor(Color.rgb(24, 30, 26))
        }
        root.addView(command, matchWrap())

        val run = Button(this).apply {
            text = "تنفيذ"
            setTextColor(Color.BLACK)
            setBackgroundColor(green)
            setOnClickListener { runCommand() }
        }
        root.addView(run, matchWrap())
        setContentView(root)
    }

    private fun runCommand() {
        val input = command.text.toString().trim()
        if (input.isEmpty()) return
        val response = when (input.lowercase()) {
            "help" -> "الأوامر المتاحة حاليًا:\nhelp  — المساعدة\nclear — مسح الشاشة\nabout — معلومات التطبيق"
            "clear" -> {
                output.text = ""
                command.setText("")
                return
            }
            "about" -> "ZORO MINI TERMINAL PRO\nالإصدار 1.0.0\nنسخة تأسيسية آمنة."
            else -> "الأمر غير معروف في النسخة الحالية. اكتب help."
        }
        output.append("\n$ $input\n$response\n")
        command.setText("")
    }

    private fun matchWrap() = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
    )
}
