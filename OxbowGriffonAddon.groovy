/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.awt.Window
import griffon.plugins.oxbow.factory.*
import com.ezware.dialog.task.TaskDialogs
import com.ezware.dialog.task.CommandLink

/**
 * @author Ixchel Ruiz
 */
class OxbowGriffonAddon {
    Map factories = [
        taskDialog: new TaskDialogFactory()
    ]

    Map methods = [
        ask: { String instruction, String text ->
            TaskDialogs.ask(getFocusedWindow(), instruction, text)
        },
        choice: { String instruction, String text, int defaultChoice, CommandLink... choices -> 
            TaskDialogs.choice(getFocusedWindow(), instruction, text, defaultChoice, choices)
        },
        confirm: { String instruction, String text ->
            TaskDialogs.isConfirmed(getFocusedWindow(), instruction, text)
        },
        error: { String instruction, String text ->
            TaskDialogs.error(getFocusedWindow(), instruction, text)
        },
        inform: { String instruction, String text ->
            TaskDialogs.inform(getFocusedWindow(), instruction, text)
        },/*
        input: { String instruction, String text, defaultValue ->
            TaskDialogs.input(getFocusedWindow(), instruction, text, defaultValue)
        },*/
        radioChoice: { String instruction, String text, int defaultChoice, String... choices -> 
            TaskDialogs.radioChoice(getFocusedWindow(), instruction, text, defaultChoice, choices)
        },
        showException: { Exception args -> TaskDialogs.showException(args) },
        warn: { String instruction, String text ->
            TaskDialogs.warn(getFocusedWindow(), instruction, text)
        },
    ]

    private Window getFocusedWindow() {
        Window.windows.find { it.focused == true } ?: null
    }
}
