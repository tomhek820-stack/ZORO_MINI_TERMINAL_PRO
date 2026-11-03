# ZORO MINI TERMINAL PRO

مشروع أندرويد تأسيسي جديد، بواجهة سوداء وخضراء، مجهز للبناء عبر GitHub Actions.

## الوضع الحالي
- واجهة طرفية أولية.
- أوامر داخلية تجريبية: `help` و`clear` و`about`.
- لا ينفذ أوامر نظام حقيقية بعد.
- البناء الآلي يرفع APK كـ Artifact عند نجاح GitHub Actions.

## البناء
افتح تبويب **Actions** في مستودع GitHub وشغّل سير العمل **Android Debug APK**. بعد نجاحه نزّل Artifact باسم `ZORO-MINI-TERMINAL-PRO-debug`.

## المتطلبات
- JDK 17
- Gradle 8.9
- Android SDK 35

## ملاحظة
هذه نقطة البداية فقط؛ تنفيذ أوامر حقيقية وإدارة الملفات والشبكة ستضاف وتختبر في مراحل لاحقة.
