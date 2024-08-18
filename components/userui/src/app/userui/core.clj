(ns app.userui.core
	(:require [hiccup2.core :as h]))

(defn home-page
	[]
	[:section
	 [:div.mx-auto.max-w-screen-2xl.px-4.py-8.sm:px-6.lg:px-8
		[:div.grid.grid-cols-1.gap-4.md:grid-cols-2
		 [:div.bg-blue-600.p-8.md:p-12.lg:px-16.lg:py-24
			[:div.mx-auto.max-w-xl.text-center
			 [:h2.text-2xl.font-bold.text-white.md:text-3xl "Lorem, ipsum dolor sit amet consectetur adipisicing elit"]
			 [:p.hidden.sm:mt-4.sm:block {:class "text-white/90"} "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Et, egestas
						tempus tellus etiam sed. Quam a scelerisque amet ullamcorper eu enim
						et fermentum, augue. Aliquet amet volutpat quisque ut interdum
						tincidunt duis."]
			 [:div.mt-4.md:mt-8
				[:a.inline-block.rounded.border.border-white.bg-white.px-12.py-3.text-sm.font-medium.text-blue-500.transition.hover:bg-transparent.hover:text-white.focus:outline-none.focus:ring.focus:ring-yellow-400
				 {:href "/sign-in"}
				 "Get Started Today"]]]]
		 [:div.grid.grid-cols-2.gap-4.md:grid-cols-1.lg:grid-cols-2
			[:img.h-40.w-full.object-cover.sm:h-56.md:h-full {:alt "Student" :src "https://images.unsplash.com/photo-1621274790572-7c32596bc67f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=654&q=80"}]
			[:img.h-40.w-full.object-cover.sm:h-56.md:h-full {:alt "Student" :src "https://images.unsplash.com/photo-1567168544813-cc03465b4fa8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"}]]]]])

(defn sign-in-form
	[{:keys [error]}]
	[:form.mt-8.grid.grid-cols-6.gap-6
	 {:hx-post "/sign-in"
		:hx-target "this"
		:hx-swap "outerHTML"}
	 ;; Just a simple example, but could be extended to implement complex form validation
	 (when error [:div.col-span-6.rounded-sm.bg-red-300.text-white.p-10
								error])
	 [:div.col-span-6
		[:label.block.text-sm.font-medium.text-gray-700.dark:text-gray-200 {:for "Email"} "Email"]
		[:input#Email.block.w-full.rounded-md.border-0.py-1.5.text-gray-900.shadow-sm.ring-1.ring-inset.ring-gray-300.placeholder:text-gray-400.focus:ring-2.focus:ring-inset.focus:ring-indigo-600.sm:text-sm.sm:leading-6
		 {:type "email" :name "email"
			:autocomplete "off"}]]
	 [:div.col-span-6
		[:label.block.text-sm.font-medium.text-gray-700.dark:text-gray-200 {:for "Password"} "Password"]
		[:input#Password.block.w-full.rounded-md.border-0.py-1.5.text-gray-900.shadow-sm.ring-1.ring-inset.ring-gray-300.placeholder:text-gray-400.focus:ring-2.focus:ring-inset.focus:ring-indigo-600.sm:text-sm.sm:leading-6 {:type "password" :name "password"}]]
	 [:div.col-span-6.sm:flex.sm:items-center.sm:gap-4
		[:button.inline-block.shrink-0.rounded-md.border.border-blue-600.bg-blue-600.px-12.py-3.text-sm.font-medium.text-white.transition.hover:bg-transparent.hover:text-blue-600.focus:outline-none.focus:ring.active:text-blue-500.dark:hover:bg-blue-700.dark:hover:text-white "Sign In"]
		[:p.mt-4.text-sm.text-gray-500.dark:text-gray-400.sm:mt-0 "Don't have an account? "
		 [:a.text-gray-700.underline.dark:text-gray-200
			{:hx-target "body"
			 :href "/sign-up"} "Sign up"] "."]]])

(defn sign-in-page
	[]
	[:section.bg-white.dark:bg-gray-900
	 [:div.lg:grid.lg:min-h-screen.lg:grid-cols-12
		[:section.relative.flex.h-32.items-end.bg-gray-900.lg:col-span-5.lg:h-full.xl:col-span-6
		 [:img.absolute.inset-0.h-full.w-full.object-cover.opacity-80 {:alt "Night" :src "photo-1.avif"}]
		 [:div.hidden.lg:relative.lg:block.lg:p-12
			[:a.block.text-white {:href "/"}
			 [:span.sr-only "Home"]
			 [:svg.h-8.sm:h-10 {:viewBox "0 0 28 24" :fill "none" :xmlns "http://www.w3.org/2000/svg"}
				[:path {:d "M0.41 10.3847C1.14777 7.4194 2.85643 4.7861 5.2639 2.90424C7.6714 1.02234 10.6393 0 13.695 0C16.7507 0 19.7186 1.02234 22.1261 2.90424C24.5336 4.7861 26.2422 7.4194 26.98 10.3847H25.78C23.7557 10.3549 21.7729 10.9599 20.11 12.1147C20.014 12.1842 19.9138 12.2477 19.81 12.3047H19.67C19.5662 12.2477 19.466 12.1842 19.37 12.1147C17.6924 10.9866 15.7166 10.3841 13.695 10.3841C11.6734 10.3841 9.6976 10.9866 8.02 12.1147C7.924 12.1842 7.8238 12.2477 7.72 12.3047H7.58C7.4762 12.2477 7.376 12.1842 7.28 12.1147C5.6171 10.9599 3.6343 10.3549 1.61 10.3847H0.41ZM23.62 16.6547C24.236 16.175 24.9995 15.924 25.78 15.9447H27.39V12.7347H25.78C24.4052 12.7181 23.0619 13.146 21.95 13.9547C21.3243 14.416 20.5674 14.6649 19.79 14.6649C19.0126 14.6649 18.2557 14.416 17.63 13.9547C16.4899 13.1611 15.1341 12.7356 13.745 12.7356C12.3559 12.7356 11.0001 13.1611 9.86 13.9547C9.2343 14.416 8.4774 14.6649 7.7 14.6649C6.9226 14.6649 6.1657 14.416 5.54 13.9547C4.4144 13.1356 3.0518 12.7072 1.66 12.7347H0V15.9447H1.61C2.39051 15.924 3.154 16.175 3.77 16.6547C4.908 17.4489 6.2623 17.8747 7.65 17.8747C9.0377 17.8747 10.392 17.4489 11.53 16.6547C12.1468 16.1765 12.9097 15.9257 13.69 15.9447C14.4708 15.9223 15.2348 16.1735 15.85 16.6547C16.9901 17.4484 18.3459 17.8738 19.735 17.8738C21.1241 17.8738 22.4799 17.4484 23.62 16.6547ZM23.62 22.3947C24.236 21.915 24.9995 21.664 25.78 21.6847H27.39V18.4747H25.78C24.4052 18.4581 23.0619 18.886 21.95 19.6947C21.3243 20.156 20.5674 20.4049 19.79 20.4049C19.0126 20.4049 18.2557 20.156 17.63 19.6947C16.4899 18.9011 15.1341 18.4757 13.745 18.4757C12.3559 18.4757 11.0001 18.9011 9.86 19.6947C9.2343 20.156 8.4774 20.4049 7.7 20.4049C6.9226 20.4049 6.1657 20.156 5.54 19.6947C4.4144 18.8757 3.0518 18.4472 1.66 18.4747H0V21.6847H1.61C2.39051 21.664 3.154 21.915 3.77 22.3947C4.908 23.1889 6.2623 23.6147 7.65 23.6147C9.0377 23.6147 10.392 23.1889 11.53 22.3947C12.1468 21.9165 12.9097 21.6657 13.69 21.6847C14.4708 21.6623 15.2348 21.9135 15.85 22.3947C16.9901 23.1884 18.3459 23.6138 19.735 23.6138C21.1241 23.6138 22.4799 23.1884 23.62 22.3947Z" :fill "currentColor"}]]]
			[:h2.mt-6.text-2xl.font-bold.text-white.sm:text-3xl.md:text-4xl "Welcome to Squid 🦑"]
			[:p.mt-4.leading-relaxed {:class "text-white/90"} "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Eligendi nam
					dolorum aliquam, quibusdam aperiam voluptatum."]]]
		[:main.flex.items-center.justify-center.px-8.py-8.sm:px-12.lg:col-span-7.lg:px-16.lg:py-12.xl:col-span-6
		 [:div.max-w-xl.lg:max-w-3xl
			[:div.relative.-mt-16.block.lg:hidden
			 [:a.inline-flex.h-16.w-16.items-center.justify-center.rounded-full.bg-white.text-blue-600.dark:bg-gray-900.sm:h-20.sm:w-20 {:href "/"}
				[:span.sr-only "Home"]
				[:svg.h-8.sm:h-10 {:viewBox "0 0 28 24" :fill "none" :xmlns "http://www.w3.org/2000/svg"}
				 [:path {:d "M0.41 10.3847C1.14777 7.4194 2.85643 4.7861 5.2639 2.90424C7.6714 1.02234 10.6393 0 13.695 0C16.7507 0 19.7186 1.02234 22.1261 2.90424C24.5336 4.7861 26.2422 7.4194 26.98 10.3847H25.78C23.7557 10.3549 21.7729 10.9599 20.11 12.1147C20.014 12.1842 19.9138 12.2477 19.81 12.3047H19.67C19.5662 12.2477 19.466 12.1842 19.37 12.1147C17.6924 10.9866 15.7166 10.3841 13.695 10.3841C11.6734 10.3841 9.6976 10.9866 8.02 12.1147C7.924 12.1842 7.8238 12.2477 7.72 12.3047H7.58C7.4762 12.2477 7.376 12.1842 7.28 12.1147C5.6171 10.9599 3.6343 10.3549 1.61 10.3847H0.41ZM23.62 16.6547C24.236 16.175 24.9995 15.924 25.78 15.9447H27.39V12.7347H25.78C24.4052 12.7181 23.0619 13.146 21.95 13.9547C21.3243 14.416 20.5674 14.6649 19.79 14.6649C19.0126 14.6649 18.2557 14.416 17.63 13.9547C16.4899 13.1611 15.1341 12.7356 13.745 12.7356C12.3559 12.7356 11.0001 13.1611 9.86 13.9547C9.2343 14.416 8.4774 14.6649 7.7 14.6649C6.9226 14.6649 6.1657 14.416 5.54 13.9547C4.4144 13.1356 3.0518 12.7072 1.66 12.7347H0V15.9447H1.61C2.39051 15.924 3.154 16.175 3.77 16.6547C4.908 17.4489 6.2623 17.8747 7.65 17.8747C9.0377 17.8747 10.392 17.4489 11.53 16.6547C12.1468 16.1765 12.9097 15.9257 13.69 15.9447C14.4708 15.9223 15.2348 16.1735 15.85 16.6547C16.9901 17.4484 18.3459 17.8738 19.735 17.8738C21.1241 17.8738 22.4799 17.4484 23.62 16.6547ZM23.62 22.3947C24.236 21.915 24.9995 21.664 25.78 21.6847H27.39V18.4747H25.78C24.4052 18.4581 23.0619 18.886 21.95 19.6947C21.3243 20.156 20.5674 20.4049 19.79 20.4049C19.0126 20.4049 18.2557 20.156 17.63 19.6947C16.4899 18.9011 15.1341 18.4757 13.745 18.4757C12.3559 18.4757 11.0001 18.9011 9.86 19.6947C9.2343 20.156 8.4774 20.4049 7.7 20.4049C6.9226 20.4049 6.1657 20.156 5.54 19.6947C4.4144 18.8757 3.0518 18.4472 1.66 18.4747H0V21.6847H1.61C2.39051 21.664 3.154 21.915 3.77 22.3947C4.908 23.1889 6.2623 23.6147 7.65 23.6147C9.0377 23.6147 10.392 23.1889 11.53 22.3947C12.1468 21.9165 12.9097 21.6657 13.69 21.6847C14.4708 21.6623 15.2348 21.9135 15.85 22.3947C16.9901 23.1884 18.3459 23.6138 19.735 23.6138C21.1241 23.6138 22.4799 23.1884 23.62 22.3947Z" :fill "currentColor"}]]]
			 [:h1.mt-2.text-2xl.font-bold.text-gray-900.dark:text-white.sm:text-3xl.md:text-4xl "Welcome to Squid 🦑"]
			 [:p.mt-4.leading-relaxed.text-gray-500.dark:text-gray-400 "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Eligendi
						nam dolorum aliquam, quibusdam aperiam voluptatum."]]
			(sign-in-form {})]]]])


(defn sign-up-form
	[{:keys [error]}]
	[:form.mt-8.grid.grid-cols-6.gap-6
	 {:hx-post "/sign-up"
		:hx-target "this"
		:hx-swap "outerHTML"}
	 ;; Just a simple example, but could be extended to implement complex form validation
	 (when error [:div.col-span-6.rounded-sm.bg-red-300.text-white.p-10
								error])
	 [:div.col-span-6
		[:label.block.text-sm.font-medium.text-gray-700.dark:text-gray-200 {:for "Email"} "Email"]
		[:input#Email.block.w-full.rounded-md.border-0.py-1.5.text-gray-900.shadow-sm.ring-1.ring-inset.ring-gray-300.placeholder:text-gray-400.focus:ring-2.focus:ring-inset.focus:ring-indigo-600.sm:text-sm.sm:leading-6
		 {:type "email"
			:name "email"
			:autocomplete "off"}]]
	 [:div.col-span-6
		[:label.block.text-sm.font-medium.text-gray-700.dark:text-gray-200 {:for "password"} "Password"]
		[:input#password.block.w-full.rounded-md.border-0.py-1.5.text-gray-900.shadow-sm.ring-1.ring-inset.ring-gray-300.placeholder:text-gray-400.focus:ring-2.focus:ring-inset.focus:ring-indigo-600.sm:text-sm.sm:leading-6
		 {:type "password"
			:name "password"}]]
	 [:div.col-span-6
		[:label.block.text-sm.font-medium.text-gray-700.dark:text-gray-200
		 {:for "password-confirmation"}
		 "Password Confirmation"]
		[:input#password-confirmation.block.w-full.rounded-md.border-0.py-1.5.text-gray-900.shadow-sm.ring-1.ring-inset.ring-gray-300.placeholder:text-gray-400.focus:ring-2.focus:ring-inset.focus:ring-indigo-600.sm:text-sm.sm:leading-6
		 {:type "password"
			:name "password-confirmation"}]]
	 [:div.col-span-6.sm:flex.sm:items-center.sm:gap-4
		[:button.inline-block.shrink-0.rounded-md.border.border-blue-600.bg-blue-600.px-12.py-3.text-sm.font-medium.text-white.transition.hover:bg-transparent.hover:text-blue-600.focus:outline-none.focus:ring.active:text-blue-500.dark:hover:bg-blue-700.dark:hover:text-white "Create an account"]
		[:p.mt-4.text-sm.text-gray-500.dark:text-gray-400.sm:mt-0 "Already have an account? "
		 [:a.text-gray-700.underline.dark:text-gray-200
			{:href "/sign-in"
			 :hx-target "body"}
			"Sign in"] "."]]])

(defn sign-up-page
	[]
	[:section.bg-white.dark:bg-gray-900
	 [:div.lg:grid.lg:min-h-screen.lg:grid-cols-12
		[:section.relative.flex.h-32.items-end.bg-gray-900.lg:col-span-5.lg:h-full.xl:col-span-6
		 [:img.absolute.inset-0.h-full.w-full.object-cover.opacity-80 {:alt "Night" :src "photo-1.avif"}]
		 [:div.hidden.lg:relative.lg:block.lg:p-12
			[:a.block.text-white {:href "/"}
			 [:span.sr-only "Home"]
			 [:svg.h-8.sm:h-10 {:viewBox "0 0 28 24" :fill "none" :xmlns "http://www.w3.org/2000/svg"}
				[:path {:d "M0.41 10.3847C1.14777 7.4194 2.85643 4.7861 5.2639 2.90424C7.6714 1.02234 10.6393 0 13.695 0C16.7507 0 19.7186 1.02234 22.1261 2.90424C24.5336 4.7861 26.2422 7.4194 26.98 10.3847H25.78C23.7557 10.3549 21.7729 10.9599 20.11 12.1147C20.014 12.1842 19.9138 12.2477 19.81 12.3047H19.67C19.5662 12.2477 19.466 12.1842 19.37 12.1147C17.6924 10.9866 15.7166 10.3841 13.695 10.3841C11.6734 10.3841 9.6976 10.9866 8.02 12.1147C7.924 12.1842 7.8238 12.2477 7.72 12.3047H7.58C7.4762 12.2477 7.376 12.1842 7.28 12.1147C5.6171 10.9599 3.6343 10.3549 1.61 10.3847H0.41ZM23.62 16.6547C24.236 16.175 24.9995 15.924 25.78 15.9447H27.39V12.7347H25.78C24.4052 12.7181 23.0619 13.146 21.95 13.9547C21.3243 14.416 20.5674 14.6649 19.79 14.6649C19.0126 14.6649 18.2557 14.416 17.63 13.9547C16.4899 13.1611 15.1341 12.7356 13.745 12.7356C12.3559 12.7356 11.0001 13.1611 9.86 13.9547C9.2343 14.416 8.4774 14.6649 7.7 14.6649C6.9226 14.6649 6.1657 14.416 5.54 13.9547C4.4144 13.1356 3.0518 12.7072 1.66 12.7347H0V15.9447H1.61C2.39051 15.924 3.154 16.175 3.77 16.6547C4.908 17.4489 6.2623 17.8747 7.65 17.8747C9.0377 17.8747 10.392 17.4489 11.53 16.6547C12.1468 16.1765 12.9097 15.9257 13.69 15.9447C14.4708 15.9223 15.2348 16.1735 15.85 16.6547C16.9901 17.4484 18.3459 17.8738 19.735 17.8738C21.1241 17.8738 22.4799 17.4484 23.62 16.6547ZM23.62 22.3947C24.236 21.915 24.9995 21.664 25.78 21.6847H27.39V18.4747H25.78C24.4052 18.4581 23.0619 18.886 21.95 19.6947C21.3243 20.156 20.5674 20.4049 19.79 20.4049C19.0126 20.4049 18.2557 20.156 17.63 19.6947C16.4899 18.9011 15.1341 18.4757 13.745 18.4757C12.3559 18.4757 11.0001 18.9011 9.86 19.6947C9.2343 20.156 8.4774 20.4049 7.7 20.4049C6.9226 20.4049 6.1657 20.156 5.54 19.6947C4.4144 18.8757 3.0518 18.4472 1.66 18.4747H0V21.6847H1.61C2.39051 21.664 3.154 21.915 3.77 22.3947C4.908 23.1889 6.2623 23.6147 7.65 23.6147C9.0377 23.6147 10.392 23.1889 11.53 22.3947C12.1468 21.9165 12.9097 21.6657 13.69 21.6847C14.4708 21.6623 15.2348 21.9135 15.85 22.3947C16.9901 23.1884 18.3459 23.6138 19.735 23.6138C21.1241 23.6138 22.4799 23.1884 23.62 22.3947Z" :fill "currentColor"}]]]
			[:h2.mt-6.text-2xl.font-bold.text-white.sm:text-3xl.md:text-4xl "Welcome to Squid 🦑"]
			[:p.mt-4.leading-relaxed {:class "text-white/90"} "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Eligendi nam
					dolorum aliquam, quibusdam aperiam voluptatum."]]]
		[:main.flex.items-center.justify-center.px-8.py-8.sm:px-12.lg:col-span-7.lg:px-16.lg:py-12.xl:col-span-6
		 [:div.max-w-xl.lg:max-w-3xl
			[:div.relative.-mt-16.block.lg:hidden
			 [:a.inline-flex.h-16.w-16.items-center.justify-center.rounded-full.bg-white.text-blue-600.dark:bg-gray-900.sm:h-20.sm:w-20 {:href "/"}
				[:span.sr-only "Home"]
				[:svg.h-8.sm:h-10 {:viewBox "0 0 28 24" :fill "none" :xmlns "http://www.w3.org/2000/svg"}
				 [:path {:d "M0.41 10.3847C1.14777 7.4194 2.85643 4.7861 5.2639 2.90424C7.6714 1.02234 10.6393 0 13.695 0C16.7507 0 19.7186 1.02234 22.1261 2.90424C24.5336 4.7861 26.2422 7.4194 26.98 10.3847H25.78C23.7557 10.3549 21.7729 10.9599 20.11 12.1147C20.014 12.1842 19.9138 12.2477 19.81 12.3047H19.67C19.5662 12.2477 19.466 12.1842 19.37 12.1147C17.6924 10.9866 15.7166 10.3841 13.695 10.3841C11.6734 10.3841 9.6976 10.9866 8.02 12.1147C7.924 12.1842 7.8238 12.2477 7.72 12.3047H7.58C7.4762 12.2477 7.376 12.1842 7.28 12.1147C5.6171 10.9599 3.6343 10.3549 1.61 10.3847H0.41ZM23.62 16.6547C24.236 16.175 24.9995 15.924 25.78 15.9447H27.39V12.7347H25.78C24.4052 12.7181 23.0619 13.146 21.95 13.9547C21.3243 14.416 20.5674 14.6649 19.79 14.6649C19.0126 14.6649 18.2557 14.416 17.63 13.9547C16.4899 13.1611 15.1341 12.7356 13.745 12.7356C12.3559 12.7356 11.0001 13.1611 9.86 13.9547C9.2343 14.416 8.4774 14.6649 7.7 14.6649C6.9226 14.6649 6.1657 14.416 5.54 13.9547C4.4144 13.1356 3.0518 12.7072 1.66 12.7347H0V15.9447H1.61C2.39051 15.924 3.154 16.175 3.77 16.6547C4.908 17.4489 6.2623 17.8747 7.65 17.8747C9.0377 17.8747 10.392 17.4489 11.53 16.6547C12.1468 16.1765 12.9097 15.9257 13.69 15.9447C14.4708 15.9223 15.2348 16.1735 15.85 16.6547C16.9901 17.4484 18.3459 17.8738 19.735 17.8738C21.1241 17.8738 22.4799 17.4484 23.62 16.6547ZM23.62 22.3947C24.236 21.915 24.9995 21.664 25.78 21.6847H27.39V18.4747H25.78C24.4052 18.4581 23.0619 18.886 21.95 19.6947C21.3243 20.156 20.5674 20.4049 19.79 20.4049C19.0126 20.4049 18.2557 20.156 17.63 19.6947C16.4899 18.9011 15.1341 18.4757 13.745 18.4757C12.3559 18.4757 11.0001 18.9011 9.86 19.6947C9.2343 20.156 8.4774 20.4049 7.7 20.4049C6.9226 20.4049 6.1657 20.156 5.54 19.6947C4.4144 18.8757 3.0518 18.4472 1.66 18.4747H0V21.6847H1.61C2.39051 21.664 3.154 21.915 3.77 22.3947C4.908 23.1889 6.2623 23.6147 7.65 23.6147C9.0377 23.6147 10.392 23.1889 11.53 22.3947C12.1468 21.9165 12.9097 21.6657 13.69 21.6847C14.4708 21.6623 15.2348 21.9135 15.85 22.3947C16.9901 23.1884 18.3459 23.6138 19.735 23.6138C21.1241 23.6138 22.4799 23.1884 23.62 22.3947Z" :fill "currentColor"}]]]
			 [:h1.mt-2.text-2xl.font-bold.text-gray-900.dark:text-white.sm:text-3xl.md:text-4xl "Welcome to Squid 🦑"]
			 [:p.mt-4.leading-relaxed.text-gray-500.dark:text-gray-400 "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Eligendi
						nam dolorum aliquam, quibusdam aperiam voluptatum."]]
			(sign-up-form {})]]]])

;; Prepare the hicup to return it as html
(defn template [html-body]
	[:html
	 [:head 
		[:title "Title"]
		[:link {:href "tailwind.min.css" :rel "stylesheet"}]
		[:script {:src "htmx.min.js"}]]
		 [:body (h/raw html-body)]])

(defn ok [body]
	{:status 200
	 :headers {"Content-Type" "text/html" "Content-Security-Policy" "img-src 'self'"}
	 :body (-> body
						(h/html)
						(str))})

(defn respond [request content]
	(ok (template (str (h/html (content))))))

;; Handlers
(defn sign-in-handler [request]
	(respond request sign-in-page))

(defn sign-up-handler [request]
	(respond request sign-up-page))

(defn home-page-handler [request]
	(respond request home-page))

(def routes
  #{["/sign-in"
     :get sign-in-handler
     :route-name ::sign-in]
    ["/sign-up"
     :get sign-up-handler
     :route-name ::sign-up]
		["/"
		 :get home-page-handler
		 :route-name ::home-page]})