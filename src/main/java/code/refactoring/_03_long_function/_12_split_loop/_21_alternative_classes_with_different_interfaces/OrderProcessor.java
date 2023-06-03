package code.refactoring._03_long_function._12_split_loop._21_alternative_classes_with_different_interfaces;

public class OrderProcessor {

    private EmailService emailService;

    public void notifyShipping(Shipping shipping) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTitle(shipping.getOrder() + " is shipped");
        emailMessage.setTo(shipping.getEmail());
        emailMessage.setFrom("no-reply@whiteship.com");
        emailService.sendEmail(emailMessage);
    }

}
