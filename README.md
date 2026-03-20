## Simple School Records Manager
An open-source school records manager with a fully dedicated database system.\
Made purely using Java Swing.

> [!NOTE]
> You can modify the database system to add your own API or application framework whether it'd be for school or business oriented.
> Documentation is fully available for everyone who wants to tinker with this application.


## Flowchart
If you want to visualize how this application and its database system works, a flowchart of it is available.

## Documentation
### `appproject.lib.AppWindow`
##### `AppWindow(title, x, y, width, height, resizable)`
Sets up an application window.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `title` | String | The application window's title. |
| `x` | int | The x position of the application window. |
| `y` | int | The y position of the application window. |
| `width` | int | The width of the application window. |
| `height` | int | The height of the application window. |
| `resizable` | boolean | If window is resizable. |

##### `AppWindow(title, resizable)`
Sets up a centered application window. Width and height values are acquired from any active monitor resolution.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `title` | String | The application window's title. |
| `resizable` | boolean | If window is resizable. |


##### `AppWindow.setUpMenu(label, items)`
Sets up the menu button with or without items. Initializes in the AppWindow's menuBar.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `label` | String | Button label of the Menu. |
| `items` | ArrayList<JMenuItem> | Items contained in the Menu. |


##### `AppWindow.setUpMenuInMenu(label, items)`
Sets up the menu button with or without items in an existing menu.\
Returns `JMenu`.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `label` | String | Button label of the Menu. |
| `items` | ArrayList<JMenuItem> | Items contained in the Menu. |

##### `AppWindow.configureMenu(menu, l)`
***Deprecated.*** Use `JMenu.addMenuListener()` instead.\
Configures the listener for the JMenu.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `menu` | JMenu | The JMenu to be configured. |
| `l` | MenuListener | The configured listener. |

##### `AppWindow.configureMenuItem(menuItem, l)`
***Deprecated.*** Use `JMenuItem.addActionListener()` instead.\
Configures the action listener for the JMenuIItem.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `menuItem` | JMenuItem | The JMenuItem to be configured. |
| `l` | ActionListener | The configured listener. |

##### `AppWindow.showContentPane(WindowContainer c)`
***Deprecated.*** Use `AppWindow.showContent()` instead.\
Shows the existing container as main pane. Will disable previous pane.\
Returns `WindowContainer`.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `c` | WindowContainer | Selected container to be shown. |

##### `AppWindow.showContentPaneAsDialog(c, title, width, height, modal)`
Shows the existing container as a separate window or dialog.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `c` | WindowContainer | Selected container to be shown. |
| `title` | String | The title of the dialog. |
| `width` | int | The width of the dialog. |
| `height` | int | The height of the dialog. |
| `modal` | boolean | The modality of the dialog (whether it can allow inputs from other windows or not). |

##### `AppWindow.showContentPaneAsDialog(c, title, width, height, modal, wl)`
Shows the existing container as a separate window or dialog, with WindowListener.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `c` | WindowContainer | Selected container to be shown. |
| `title` | String | The title of the dialog. |
| `width` | int | The width of the dialog. |
| `height` | int | The height of the dialog. |
| `modal` | boolean | The modality of the dialog (whether it can allow inputs from other windows or not). |
| `wl` | WindowListener | The WindowListener. |

##### `AppWindow.debugPrintln(message, type)`
***Static function.***\
Prints out a detailed console print for debugging. It includes a timestamp and date to when the message was invoked.
| Parameters | Data Type | Description |
| :--- | :--- | :--- |
| `message` | Object | The message. |
| `type` | String | The type of the message print. |

### `appproject.lib.WindowContainer`
##### `WindowContainer()`
Sets up the WindowContainer. Also known as the content for AppWindow.\
Custom containers inheriting WindowContainer should use `super()` as the first statement in their constructors.\
