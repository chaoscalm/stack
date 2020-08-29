@file:Suppress("MagicNumber")
package me.tylerbwong.markdown.compose.visitors

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import me.tylerbwong.markdown.compose.builder.buildMarkdown
import org.intellij.markdown.IElementType
import org.intellij.markdown.MarkdownElementTypes
import org.intellij.markdown.MarkdownTokenTypes
import org.intellij.markdown.ast.ASTNode

internal class HeaderVisitor(
    content: String,
    private val headerType: IElementType
) : Visitor(content) {

    override fun accept(node: ASTNode, builder: AnnotatedString.Builder) {
        builder.withStyle(SpanStyle(fontSize = resolveHeaderTextSize())) {
            node.children
                .drop(1) // Drop the header token
                .dropWhile { it.type == MarkdownTokenTypes.WHITE_SPACE }
                .forEach { buildMarkdown(it, content) }
        }
    }

    private fun resolveHeaderTextSize() = when (headerType) {
        MarkdownElementTypes.SETEXT_1, MarkdownElementTypes.ATX_1 -> 24.sp
        MarkdownElementTypes.SETEXT_2, MarkdownElementTypes.ATX_2 -> 20.sp
        MarkdownElementTypes.ATX_3 -> 18.sp
        MarkdownElementTypes.ATX_4 -> 16.sp
        MarkdownElementTypes.ATX_5 -> 14.sp
        MarkdownElementTypes.ATX_6 -> 12.sp
        else -> TextUnit.Inherit
    }
}
