package components

import models.*
import models.ComponentParams.Companion.CENTER_HORIZONTAL
import models.ComponentParams.Companion.CENTER_VERTICAL
import models.ComponentParams.Companion.MATCH_PARENT
import models.ComponentParams.Companion.ORIENTATION_HORIZONTAL
import models.ComponentParams.Companion.ORIENTATION_VERTICAL

object ComponentFactory {

    fun getResponseComponents(): List<Component> {
        val imageComponent = getImageComponent(
            url = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Kotlin-logo.svg/512px-Kotlin-logo.svg.png",
            params = ComponentParams(
                width = "256",
                height = "256"
            )
        )

        val titleComponent = getTextComponent(
            text = "Kotlin language",
            style = ComponentStyle(
                textSize = 19,
                textColor = "#333333"
            )
        )

        val descriptionComponent = getTextComponent(
            text = "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference.",
            params = ComponentParams(
                margin = ComponentIndent(
                    vertical = 8
                )
            ),
            style = ComponentStyle(
                textSize = 15,
                textColor = "#666666"
            )
        )

        val inputComponent = getInputComponent(
            hint = "Input here...",
            params = ComponentParams(
                width = MATCH_PARENT,
                padding = ComponentIndent(all = 12),
                margin = ComponentIndent(all = 12)
            ),
            style = ComponentStyle(
                backgroundColor = "#F9F9F9",
                textColor = "#333333",
                textSize = 17
            )
        )

        val infoComponent = getComponent(
            type = ComponentConstants.LINEAR_COMPONENT,
            params = ComponentParams(
                weight = 1,
                margin = ComponentIndent(horizontal = 12)
            ),
            children = arrayListOf(titleComponent, descriptionComponent)
        )

        val container = getComponent(
            type = ComponentConstants.LINEAR_COMPONENT,
            params = ComponentParams(
                width = MATCH_PARENT,
                orientation = ORIENTATION_HORIZONTAL,
                padding = ComponentIndent(all = 12)
            ),
            children = arrayListOf(imageComponent, infoComponent)
        )

        val buttonComponent = getButtonComponent(
            text = "Submit",
            params = ComponentParams(
                width = MATCH_PARENT,
                margin = ComponentIndent(all = 12)
            ),
            style = ComponentStyle(
                backgroundColor = "#FFFFFF",
                textColor = "#029ac9",
                textSize = 17
            ),
            action = ComponentAction(
                type = ComponentAction.OPEN_URL,
                uri = "https://chocotravel.com"
            )
        )

        val dividerComponent = getViewComponent(
            params = ComponentParams(
                width = MATCH_PARENT,
                height = "1"
            ),
            style = ComponentStyle(
                backgroundColor = "#9E9E9E"
            )
        )

        val parent = getComponent(
            type = ComponentConstants.LINEAR_COMPONENT,
            params = ComponentParams(
                width = MATCH_PARENT
            ),
            style = ComponentStyle(
                backgroundColor = "#FFFFFF"
            ),
            children = arrayListOf(container, inputComponent, buttonComponent,
                dividerComponent)
        )

        return arrayListOf(parent)
    }

    private fun getComponent(
        type: String,
        params: ComponentParams,
        style: ComponentStyle = ComponentStyle(),
        action: ComponentAction? = null,
        children: ArrayList<Component>? = null
    ) = Component(
                type = type,
                params = params,
                style = style,
                children = children,
                action = action)

    private fun getButtonComponent(
        text: String,
        params: ComponentParams = ComponentParams(),
        style: ComponentStyle = ComponentStyle(),
        action: ComponentAction
    ) = getComponent(
        type = ComponentConstants.BUTTON_COMPONENT,
        params = params,
        style = style,
        action = action).apply {
        this.text = text
    }

    private fun getViewComponent(
        params: ComponentParams = ComponentParams(),
        style: ComponentStyle = ComponentStyle()
    ) = getComponent(
        type = ComponentConstants.VIEW_COMPONENT,
        params = params,
        style = style)

    private fun getTextComponent(
        text: String,
        params: ComponentParams = ComponentParams(),
        style: ComponentStyle = ComponentStyle()
    ) = getComponent(
                type = ComponentConstants.TEXT_COMPONENT,
                params = params,
                style = style).apply {
                this.text = text
            }

    private fun getInputComponent(
        hint: String,
        params: ComponentParams = ComponentParams(),
        style: ComponentStyle = ComponentStyle()
    ) = getComponent(
                type = ComponentConstants.INPUT_COMPONENT,
                params = params,
                style = style).apply {
                this.hint = hint
            }

    private fun getImageComponent(
        url: String,
        params: ComponentParams = ComponentParams(),
        style: ComponentStyle = ComponentStyle()
    ) = getComponent(
                type = ComponentConstants.IMAGE_COMPONENT,
                params = params,
                style = style).apply {
                this.url = url
            }

}
