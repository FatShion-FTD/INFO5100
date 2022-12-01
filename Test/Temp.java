public class Temp {
    public class MyFrame extends JFrame {
        private static final long serialVersionUID = 1L;
    
        MenuBar menuBar; // 菜单栏
        Menu userMenu, itemMenu; // 菜单
        MenuItem addUserMenuItem, updtUserMenuItem, delUserMenuItem, addItemMenuItem, updtItemMenuItem, delItemMenuItem; // 菜单项
        Panel contentPanel; // 内容面板，其上用于添加其他待切换的面板
    
        public MenuBar getMenuBar() {
            return menuBar;
        }
    
        public void setMenuBar(MenuBar menuBar) {
            this.menuBar = menuBar;
        }
    
        public Menu getUserMenu() {
            return userMenu;
        }
    
        public void setUserMenu(Menu userMenu) {
            this.userMenu = userMenu;
        }
    
        public Menu getItemMenu() {
            return itemMenu;
        }
    
        public void setItemMenu(Menu itemMenu) {
            this.itemMenu = itemMenu;
        }
    
        public MenuItem getAddUserMenuItem() {
            return addUserMenuItem;
        }
    
        public void setAddUserMenuItem(MenuItem addUserMenuItem) {
            this.addUserMenuItem = addUserMenuItem;
        }
    
        public MenuItem getUpdtUserMenuItem() {
            return updtUserMenuItem;
        }
    
        public void setUpdtUserMenuItem(MenuItem updtUserMenuItem) {
            this.updtUserMenuItem = updtUserMenuItem;
        }
    
        public MenuItem getDelUserMenuItem() {
            return delUserMenuItem;
        }
    
        public void setDelUserMenuItem(MenuItem delUserMenuItem) {
            this.delUserMenuItem = delUserMenuItem;
        }
    
        public MenuItem getAddItemMenuItem() {
            return addItemMenuItem;
        }
    
        public void setAddItemMenuItem(MenuItem addItemMenuItem) {
            this.addItemMenuItem = addItemMenuItem;
        }
    
        public MenuItem getUpdtItemMenuItem() {
            return updtItemMenuItem;
        }
    
        public void setUpdtItemMenuItem(MenuItem updtItemMenuItem) {
            this.updtItemMenuItem = updtItemMenuItem;
        }
    
        public MenuItem getDelItemMenuItem() {
            return delItemMenuItem;
        }
    
        public void setDelItemMenuItem(MenuItem delItemMenuItem) {
            this.delItemMenuItem = delItemMenuItem;
        }
    
        public Panel getContentPanel() {
            return contentPanel;
        }
    
        public void setContentPanel(Panel contentPanel) {
            this.contentPanel = contentPanel;
        }
    
        public MyFrame() {
            // 初始化组件
            menuBar = new MenuBar();
            userMenu = new Menu("User");
    //		itemMenu = new Menu("Item");
    
            addUserMenuItem = new MenuItem("AddUser");
            updtUserMenuItem = new MenuItem("UpdateUser");
    //		delUserMenuItem = new MenuItem("DeleteUser");
    //		addItemMenuItem = new MenuItem("AddItem");
    //		updtItemMenuItem = new MenuItem("UpdateItem");
    //		delItemMenuItem = new MenuItem("DelItem");
    
            contentPanel = new Panel();
    
            // 设置窗口的菜单栏，菜单和各个菜单项。
            userMenu.add(addUserMenuItem);
            userMenu.add(updtUserMenuItem);
    //		userMenu.add(delUserMenuItem);
    //		itemMenu.add(addItemMenuItem);
    //		itemMenu.add(updtItemMenuItem);
    //		itemMenu.add(delItemMenuItem);
    
            menuBar.add(userMenu);
    //		menuBar.add(itemMenu);
            setMenuBar(menuBar);
    
            // 设置布局为边界布局管理器。将contentPanel添加到窗口中心位置。
            this.setContentPane(new MyPanel("这是欢迎页 - setContentPane()"));
    
            // 窗口的其他参数
            setTitle("测试");
            setBounds(300, 50, 400, 300);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    
        // 切换内容面板
        public void changeContentPane(Container contentPane) {
            this.setContentPane(contentPane);
            this.revalidate();
        }
    
    }
    
    //简易地获取所需的面板(使用时需自定义)
    class MyPanel extends Panel {
        public MyPanel(String msg) {
            this.add(new Label(msg));
        }
    }
}
