using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;

namespace DesktopApp
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (this.textBoxEmail.Text.Equals("oussama@mail.com") && this.passwordBox.Password.Equals("calculator"))
            {
                new Calculator().Show();
                this.Close();
            }
            else
            {
                MessageBox.Show("Wrong email or password");
            }
        }
    }
}
