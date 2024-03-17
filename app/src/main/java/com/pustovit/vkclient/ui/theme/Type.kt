package com.pustovit.vkclient.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.pustovit.vkclient.R

private val robotoFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.roboto_thin,
            weight = FontWeight.Thin,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_thin_italic,
            weight = FontWeight.Thin,
            style = FontStyle.Italic
        ),

        Font(
            resId = R.font.roboto_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_medium_italic,
            weight = FontWeight.Medium,
            style = FontStyle.Italic
        ),

        Font(
            resId = R.font.roboto_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_light_italic,
            weight = FontWeight.Light,
            style = FontStyle.Italic
        ),


        Font(
            resId = R.font.roboto_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_bold_italic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),

        Font(
            resId = R.font.roboto_black,
            weight = FontWeight.Black,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_black_italic,
            weight = FontWeight.Black,
            style = FontStyle.Italic
        ),
    )
)

private val lemonFontFamily = FontFamily(
    listOf(
        Font(
            resId = R.font.lemon_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
    )
)

private val defaultTypography = Typography()

val Typography = Typography(

    displayLarge = defaultTypography.displayLarge.copy(fontFamily = robotoFontFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = robotoFontFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = robotoFontFamily),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = lemonFontFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = lemonFontFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = lemonFontFamily),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = robotoFontFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = robotoFontFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = robotoFontFamily),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = robotoFontFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = robotoFontFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = robotoFontFamily),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = robotoFontFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = robotoFontFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = robotoFontFamily),
)