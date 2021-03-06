package de.adihubba.swing.radiobutton;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class YesNoRadioButtonHorPanel extends RadioButtonPanel implements YesNoRadioButton {
    protected JRadioButton optYes;
    protected JRadioButton optNo;

    public YesNoRadioButtonHorPanel() {
        this(false);
    }

    /**
     * @param allowDeselection if true will allow selected choices to be deselected.
     */
    public YesNoRadioButtonHorPanel(boolean allowDeselection) {
        this(SwingConstants.HORIZONTAL, allowDeselection);
    }

    protected YesNoRadioButtonHorPanel(int orientation, boolean allowDeselection) {
        super(orientation, allowDeselection);
    }

    /**
     * getter for Yes
     *
     * @return true if yes is selected
     */
    @Override
    public boolean isYesSelected() {
        return this.optYes.isSelected();
    }

    /**
     * Setter for Yes/No.
     *
     * @param yes New value of property optYes.
     */
    @Override
    public void setYesSelected(boolean yes) {
        this.optYes.setSelected(yes);
        this.optNo.setSelected(!yes);
    }

    /**
     * getter for No
     *
     * @return true if no is selected
     */
    @Override
    public boolean isNoSelected() {
        return this.optNo.isSelected();
    }

    @Override
    public Boolean getValue() {
        if (isYesSelected()) {
            return Boolean.TRUE;
        }
        if (isNoSelected()) {
            return Boolean.FALSE;
        }

        return null;
    }

    @Override
    public void setValue(Boolean value) {
        if (value == null) {
            deselect();
        }
        else {
            setYesSelected(value);
        }
    }

    @Override
    protected List<JRadioButton> createButtons() {
        List<JRadioButton> buttons = new ArrayList<>();

        optYes = new JRadioButton("Yes");
        optYes.setBounds(0, 0, 60, 20);
        buttons.add(optYes);

        optNo = new JRadioButton("No");
        optNo.setBounds(55, 0, 60, 20);
        buttons.add(optNo);

        return buttons;
    }

}
