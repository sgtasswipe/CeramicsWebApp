// main.js
document.addEventListener('DOMContentLoaded', () => {
    // Smooth scrolling for navigation links
    const navLinks = document.querySelectorAll('nav a');
    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            const targetId = link.getAttribute('href');
            const targetElement = document.querySelector(targetId);
            targetElement.scrollIntoView({ behavior: 'smooth' });
        });
    });

    // Lazy loading for product images
    const productImages = document.querySelectorAll('.product-card img');
    const imageObserver = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const img = entry.target;
                img.src = img.dataset.src;
                img.classList.add('fade-in');
                observer.unobserve(img);
            }
        });
    });

    productImages.forEach(img => {
        img.classList.add('lazy-load');
        img.dataset.src = img.src;
        img.src = '';
        imageObserver.observe(img);
    });

    // Simple form validation for contact form (if you decide to add one)
    const contactForm = document.querySelector('#contact-form');
    if (contactForm) {
        contactForm.addEventListener('submit', (e) => {
            e.preventDefault();
            // Add your form validation logic here
            alert('Thank you for your message! We will get back to you soon.');
            contactForm.reset();
        });
    }

    // main.js
    document.addEventListener('DOMContentLoaded', () => {
        // ... (keep existing code) ...

        // Contact form handling
        const contactForm = document.querySelector('#contact-form');
        if (contactForm) {
            contactForm.addEventListener('submit', (e) => {
                e.preventDefault();
                // Add your form submission logic here (e.g., AJAX request)
                alert('Thank you for your message! We will get back to you soon.');
                contactForm.reset();
            });
        }

        // Course signup handling
        const signupButtons = document.querySelectorAll('.signup-btn');
        signupButtons.forEach(button => {
            button.addEventListener('click', (e) => {
                const courseId = e.target.getAttribute('data-course-id');
                // Add your course signup logic here (e.g., AJAX request)
                alert(`Thank you for signing up for course ${courseId}! We'll contact you with further details.`);
            });
        });

        // Blog post image lazy loading
        const blogImages = document.querySelectorAll('.blog-post img');
        const imageObserver = new IntersectionObserver((entries, observer) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    const img = entry.target;
                    img.src = img.dataset.src;
                    img.classList.add('fade-in');
                    observer.unobserve(img);
                }
            });
        });

        blogImages.forEach(img => {
            img.classList.add('lazy-load');
            img.dataset.src = img.src;
            img.src = '';
            imageObserver.observe(img);
        });
    });
});
