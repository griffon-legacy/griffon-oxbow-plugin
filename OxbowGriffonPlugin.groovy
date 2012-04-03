/*
 * Copyright 2010 the original author or authors.
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

/**
 * @author Ixchel Ruiz
 */
class OxbowGriffonPlugin {
    // the plugin version
    String version = '0.4'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [miglayout: '0.4']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-oxbow-plugin'

    List authors = [
        [
            name: 'Ixchel Ruiz',
            email: 'ixchelruiz@yahoo.com'
        ]
    ]
    String title = 'MigLayout integration'
    String description = '''
Create a task Dialog based on Oxbow - A collection of projects for Swing UI enhancement [Oxbow][1].

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*     | *Property* | *Type* | *Required* | *Bindable* |
| ---------- | ---------- | ------ | ---------- | ---------- |
| taskDialog | title      | String | yes        | no         |

This plugin exposes the following methods to help you create different types of dialogs:

 * **ask()** - Shows simple questions.
 * **inform()** - Shows simple information message.
 * **confirm()** - Shows simple confirmation message.
 * **input()** - Shows simple input message.
 * **error()** - Shows simple error message.
 * **warn()** - Shows simple warnning message.
 * **showException()** - Shows simple exception message.
 * **radioChoice()** - Simplifies the presentation of choice based on radio buttons
 * **choice()** - Produces choice dialog based on command links. Task dialog commands are suppressed.

### Examples

On a View script

        application(title:'Oxbow',
          pack:true,
          locationByPlatform:true,
          iconImage: imageIcon('/griffon-icon-48x48.png').image,
          iconImages: [imageIcon('/griffon-icon-48x48.png').image,
          imageIcon('/griffon-icon-32x32.png').image,
          imageIcon('/griffon-icon-16x16.png').image]
          ) {
            panel {
            borderLayout()
            panel(constraints: NORTH) {
                  gridLayout(columns: 1, rows: 8)
                  label 'Dialogs:'
                  button ('ask', actionPerformed: controller.askAction)
                  button ('warnDialog', actionPerformed: controller.warnAction)
                  button ('inform', actionPerformed: controller.informAction)
                  button ('confirm', actionPerformed: controller.confirmAction)
                  button ('error', actionPerformed: controller.errorAction)
                  button ('showException', actionPerformed: controller.showExceptionAction)
                  button ('choice', actionPerformed: controller.choiceAction)
               }
            }
        }

On a Controller

        import com.ezware.dialog.task.CommandLink 
        class SampleController {
            def model
            def view

            def askAction = { evt = null ->
                println ask("Foo", "bar")
            } 
            def warnAction = { evt = null ->
                println warn("Foo", "bar")
            }
            def informAction = { evt = null ->
                println inform("Foo", "bar")
            }
            def confirmAction = { evt = null ->
                println confirm("Foo", "bar")
            }
            def errorAction = { evt = null ->
                println error("Foo", "bar")
            }
            def showExceptionAction = { evt = null ->
                println showException(new Exception())
            }
            def choiceAction = { evt = null ->
                println choice("Foo", "bar", 2, new CommandLink("Foo","bar"), new CommandLink("Foo1","bar1"))
            }
        }

[1]: http://code.google.com/p/oxbow/
[2]: http://migcalendar.com/miglayout/cheatsheet.html
'''
}
