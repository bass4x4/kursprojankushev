package UI;

import Backend.DBQueries;
import POJO.Game;
import POJO.GamePlays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class GamePlaysWindow {
    private JTable gamePlaysTable;
    private JPanel gamePlaysPanel;

    public GamePlaysWindow() {
        String[] columnNames = {"PLAY ID",
                "PLAY NUM",
                "TEAM ID FOR",
                "TEAM ID AGAINST",
                "EVENT",
                "PERIOD",
                "DESCRIPTION",
                "GAME ID"};
        DefaultTableModel model = new DefaultTableModel();
        gamePlaysTable.setModel(model);
        model.setColumnIdentifiers(columnNames);
        List<GamePlays> allGames = DBQueries.getAllGamePlays();
        for (GamePlays s : allGames) {
            Object[] o = new Object[8];
            o[0] = s.getPlayId();
            o[1] = s.getPlayNum();
            o[2] = s.getTeamIdFor();
            o[3] = s.getTeamIdAgainst();
            o[4] = s.getEvent();
            o[5] = s.getPeriod();
            o[6] = s.getDescription();
            o[7] = s.getGameId();
            model.addRow(o);
        }
    }


    public JTable getGamePlaysTable() {
        return gamePlaysTable;
    }

    public JPanel getGamePlaysPanel() {
        return gamePlaysPanel;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        gamePlaysPanel = new JPanel();
        gamePlaysPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        gamePlaysPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        gamePlaysTable = new JTable();
        scrollPane1.setViewportView(gamePlaysTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return gamePlaysPanel;
    }
}
